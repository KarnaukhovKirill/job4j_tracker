package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("A task", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        System.out.println(jobs);
    }
}
