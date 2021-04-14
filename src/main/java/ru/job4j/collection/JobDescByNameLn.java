package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameLn implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int length01 = o1.getName().length();
        int length02 = o2.getName().length();
        return Integer.compare(length02, length01);
    }
}
