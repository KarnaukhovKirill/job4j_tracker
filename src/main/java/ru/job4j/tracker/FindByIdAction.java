package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find Item by Id ===");
        int id = input.askInt("Enter id: ");
        Item newItem = tracker.findById(id);
        String rsl = newItem != null ? newItem.toString() : "Not found";
        out.println(rsl);
        return true;
    }
}
