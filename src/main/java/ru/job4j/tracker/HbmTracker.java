package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        item.setId(id);
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return item.equals(findById(id));
    }

    @Override
    public boolean delete(int id) {
        Item item = findById(id);
        if (item == null) {
            return false;
        }
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl;
        Session session = sf.openSession();
        session.beginTransaction();
        rsl = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void findAll(Observe<Item> observe) {
        Session session = sf.openSession();
        session.beginTransaction();
        var rsl = session.createQuery("from ru.job4j.tracker.Item").iterate();
        while (rsl.hasNext()) {
            observe.recieve((Item) rsl.next());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl;
        Session session = sf.openSession();
        session.beginTransaction();
        var query = session.createQuery("from ru.job4j.tracker.Item where name = :name");
        query.setParameter("name", key);
        rsl = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl;
        Session session = sf.openSession();
        session.beginTransaction();
        rsl = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
