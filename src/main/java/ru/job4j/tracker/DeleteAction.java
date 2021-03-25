package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
