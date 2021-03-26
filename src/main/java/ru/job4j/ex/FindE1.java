package ru.job4j.ex;

import java.util.Arrays;

public class FindE1 {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String a : value) {
            if (key.equals(a)) {
                rsl = Arrays.asList(value).indexOf(a);
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
            System.out.println(indexOf(value, "lalala"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}