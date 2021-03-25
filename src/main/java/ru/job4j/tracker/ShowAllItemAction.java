package ru.job4j.tracker;

public class ShowAllItemAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("=== List of Items ====");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(items[i]);
        }
        System.out.println("=== End ====");
        return true;
    }
}
