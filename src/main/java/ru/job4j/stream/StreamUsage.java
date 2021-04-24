package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, -3, -4, -5, -6, 7, 8, -2, 0);
        List<Integer> filterList = list.stream().filter(
                integer -> integer > 0
        ).collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }
}
