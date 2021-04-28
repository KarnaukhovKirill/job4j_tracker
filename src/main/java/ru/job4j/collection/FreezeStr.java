package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> one = new HashMap<>();
        char[] charsLeft = left.toCharArray();
        for (char c : charsLeft) {
            int i = 1;
            if (one.containsKey(c)) {
                one.put(c, one.get(c) + 1);
            } else {
                one.put(c, i);
            }
        }
        char[] charsRight = right.toCharArray();
        for (Character c : charsRight) {
            if (one.containsKey(c) && one.get(c) > 1) {
                one.put(c, one.get(c) - 1);
            } else {
                one.remove(c);
            }
        }
        return one.isEmpty();
    }
}
