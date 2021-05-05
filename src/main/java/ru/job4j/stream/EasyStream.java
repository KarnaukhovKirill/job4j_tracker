package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> integers;

    private EasyStream(List<Integer> integers) {
        this.integers = integers;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> mappingList = new ArrayList<>();
        for (var i : integers) {
            mappingList.add(fun.apply(i));
        }
        return new EasyStream(mappingList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> filterList = new ArrayList<>();
        for (var i : integers) {
            if (fun.test(i)) {
                filterList.add(i);
            }
        }
        return new EasyStream(filterList);
    }

    public List<Integer> collect() {
        return integers;
    }
}