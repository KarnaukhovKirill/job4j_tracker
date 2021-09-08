package ru.job4j.tracker;

import java.util.Random;

public class ProfileTestAction implements UserAction {
    private final Output out;

    public ProfileTestAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Profile Test Action";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            Item item = new Item("Item" + i);
            tracker.add(item);
            if (random.nextInt(50000) < i) {
                var number = random.nextInt(i);
                if (tracker.findById(number) != null) {
                    tracker.delete(number);
                }
            }
        }
        return true;
    }
}
