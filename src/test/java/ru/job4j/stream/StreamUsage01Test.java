package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StreamUsage01Test {

    @Test
    public void testSquareMatrix() {
        StreamUsage01 sU = new StreamUsage01();
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> rsl = sU.matrixToList(matrix);
        assertThat(rsl, is(expected));
    }

    @Test
    public void testNonSquareMatrix() {
        StreamUsage01 sU = new StreamUsage01();
        Integer[][] matrix = {
                {1, 2, 3, 8, 9},
                {4, 5, 6, 7}
        };
        List<Integer> expected = List.of(1, 2, 3, 8, 9, 4, 5, 6, 7);
        List<Integer> rsl = sU.matrixToList(matrix);
        assertThat(rsl, is(expected));
    }
}