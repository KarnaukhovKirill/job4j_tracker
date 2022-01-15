package ru.job4j.tracker;

public class EditIteamAction implements UserAction {

    private final Output out;

    public EditIteamAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name : ");
        Item newItem = new Item(id, name);
        String rsl = tracker.replace(id, newItem) ? "Success" : "Something's wrong";
        out.println(rsl);
        return true;
    }
}
