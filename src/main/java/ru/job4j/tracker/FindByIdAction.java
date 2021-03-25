package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter id: ");
        Item newItem = tracker.findById(id);
        if (newItem != null) {
            System.out.println(newItem);
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
