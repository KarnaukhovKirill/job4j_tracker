package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(new Job("Imp task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameUp() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(new Job("Imp task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(new Job("Imp task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityUp() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(new Job("Imp task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(new Job("Imp task", 0),
                                        new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityUpAndName() {
        Comparator<Job> cmpPriorityUpName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityUpName.compare(new Job("Imp task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenMustEquals() {
        Comparator<Job> cmpPriorityUpName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityUpName.compare(new Job("A", 1),
                new Job("A", 1)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparatorByPriorityUpAndNameUp() {
        Comparator<Job> cmpPriorityUpNameUp = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityUpNameUp.compare(new Job("Asta la vista", 100),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}