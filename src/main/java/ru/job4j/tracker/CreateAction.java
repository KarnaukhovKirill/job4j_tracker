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
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ====");
        Item item = new Item();
        String name = input.askStr("Enter name: ");
        item.setName(name);
        String description = input.askStr("Enter description");
        item.setDescription(description);
        tracker.add(item);
        return true;
    }
}
