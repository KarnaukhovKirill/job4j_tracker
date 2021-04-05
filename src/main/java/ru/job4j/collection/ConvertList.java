package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] a : list) {
            for (int e : a) {
                rsl.add(e);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = convert(in);
        System.out.println(expect);
        for (int e : expect) {
            System.out.println(e);
        }
    }
}
