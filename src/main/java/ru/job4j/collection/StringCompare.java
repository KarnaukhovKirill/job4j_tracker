package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int count = Math.max(left.length(), right.length());
        for (int index = 0; index < count; index++) {
            if (rsl != 0) {
                return rsl;
            }
            if ((index + 1) == count) {
                return Integer.compare(left.length(), right.length());
            }
            rsl = Character.compare(left.charAt(index), right.charAt(index));
        }
        return rsl;
    }
}
