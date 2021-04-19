package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] a1 = o1.split("/");
        String[] a2 = o2.split("/");
        if (a2[0].equals(a1[0])) {
            return o1.compareTo(o2);
        }
        return a2[0].compareTo(a1[0]);
    }
}
