package ru.job4j.tracker;

public final class SingleTracker {
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    private static SingleTracker singleTracker = null;

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }
}
