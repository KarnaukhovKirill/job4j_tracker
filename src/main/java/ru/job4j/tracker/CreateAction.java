package ru.job4j.tracker;

public class CreateAction implements  UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        if (tracker.findAll()[tracker.findAll().length - 1].getName().equals(name)) {
            System.out.println("Succes");
            return true;
        } else {
            System.out.println("Something's wrong");
            return false;
        }
    }
}
