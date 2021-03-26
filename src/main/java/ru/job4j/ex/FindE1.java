package ru.job4j.ex;

public class FindE1 {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = {"one", "two", "three"};
            System.out.println(indexOf(value, "three"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}