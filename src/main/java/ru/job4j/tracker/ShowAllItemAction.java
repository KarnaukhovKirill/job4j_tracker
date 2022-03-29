package ru.job4j.tracker;

import java.util.List;

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
    public boolean execute(Input input, Store tracker) {
        out.println("=== List of Items ===");
        tracker.findAll(out::println);
        out.println(" === End === ");
        return true;
    }
}
