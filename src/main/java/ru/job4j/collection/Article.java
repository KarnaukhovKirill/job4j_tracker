package ru.job4j.collection;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> one = Arrays.stream(origin.split("\\b"))
                .collect(Collectors.toSet());
        int sizeUntil = one.size();
        one.addAll(Arrays.asList(line.split("\\b")));
        int sizeAfter = one.size();
        return sizeUntil == sizeAfter;
    }
}
