package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                System.out.println("=== List of Items ====");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(items[i].getName() + " " + items[i].getId());
                }
                System.out.println("=== End ====");
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new name : ");
                String name = scanner.nextLine();
                Item newItem = new Item(id, name);
                tracker.replace(id, newItem);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);
                if (tracker.delete(id)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by Id ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item newItem = tracker.findById(id);
                if (newItem != null) {
                    System.out.println(newItem.getName() + " " + newItem.getId());
                } else {
                    System.out.println("Not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i].getName() + " " + items[i].getId());
                    }
                } else {
                    System.out.println("Not found");
                }
            } else if (select == 6) {
                System.out.println("Good Bye");
                run = !run;
            } else {
                System.out.println("Somethings wrong!");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
