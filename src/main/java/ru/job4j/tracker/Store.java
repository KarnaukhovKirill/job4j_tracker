package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {
    public void init();

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    void findAll(Observe<Item> observe);

    List<Item> findByName(String key);

    Item findById(int id);
}
