package ru.job4j.tracker;

public class EditIteamAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name : ");
        Item newItem = new Item(id, name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
