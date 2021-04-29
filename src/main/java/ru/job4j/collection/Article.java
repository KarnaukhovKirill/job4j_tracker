package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originWithoutMarks = origin.replaceAll("\\p{P}", "");
        String lineWithoutMarks = line.replaceAll("\\p{P}", "");
        String[] originWords = originWithoutMarks.split(" ");
        String[] lineWords = lineWithoutMarks.split(" ");
        Set<String> check = new HashSet<>();
        for (String str : originWords) {
            check.add(str);
        }
        boolean rsl = true;
        for (String str : lineWords) {
            rsl = check.contains(str);
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }
}
