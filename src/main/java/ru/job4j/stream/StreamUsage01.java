package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage01 {
    public static void main(String[] args) {
        System.out.println("Hello, wrld!");
    }

    public List<Integer> matrixToList(Integer[][] integers) {
        List<Integer> newList;
        newList = Stream.of(integers)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        return newList;
    }
}
