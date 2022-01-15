package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        String rsl = tracker.delete(id) ? "Success" : "Error";
        out.println(rsl);
        return true;
    }
}
