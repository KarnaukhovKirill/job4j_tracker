package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "First");
        tracker.add(first);
        System.out.println(tracker.findById(1).getName());
    }
}
