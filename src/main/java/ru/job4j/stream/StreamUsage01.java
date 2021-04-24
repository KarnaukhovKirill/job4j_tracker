package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage01 {
    public List<Integer> matrixToList(Integer[][] integers) {
        return Stream.of(integers)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
