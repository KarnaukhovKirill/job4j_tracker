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
        String description = input.askStr("Enter description");
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setDescription(description);
        String rsl = tracker.replace(id, newItem) ? "Success" : "Something's wrong";
        out.println(rsl);
        return true;
    }
}
