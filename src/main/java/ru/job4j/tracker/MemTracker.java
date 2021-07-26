package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = this.indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = this.indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> copy = new ArrayList<>();
        for (Item i : items) {
            if (key.equals(i.getName())) {
                copy.add(i);
            }
        }
        return copy;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public void close() {

    }

    @Override
    public void init() {

    }
}