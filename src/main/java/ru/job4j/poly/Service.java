package ru.job4j.poly;

public class Service {
    private DbStore store;

    public Service(DbStore store) {
        this.store = store;
    }

    public void extract() {
        store.save("Pert Arsentev");
    }

    public static void main(String[] args) {
        DbStore store = new DbStore();
        Service service = new Service(store);
        service.extract();
    }
}
