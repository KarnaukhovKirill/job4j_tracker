package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find Item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item a : items) {
                out.println(a);
            }
        } else {
            out.println("Not found");
        }
        return true;
    }
}
