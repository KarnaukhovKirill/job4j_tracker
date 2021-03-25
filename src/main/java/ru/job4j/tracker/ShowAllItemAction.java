package ru.job4j.tracker;

public class ShowAllItemAction implements UserAction {

    private final Output out;

    public ShowAllItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        out.println("=== List of Items ===");
        for (Item a : items) {
            out.println(a);
        }
        out.println(" === End === ");
        return true;
    }
}
