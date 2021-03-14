package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;


public class PointTest {

    @Test
    public void testDistanceOne() {
        Point first = new Point(0, 0);
        Point second = new Point(6, 5);
        double expect = 7.81;
        assertThat(first.distance(second), closeTo(expect, 0.01));
    }

    @Test
    public void testDistanceTwo() {
        Point first = new Point(5, 7);
        Point second = new Point(1, 30);
        double expect = 23.34;
        assertThat(first.distance(second), closeTo(expect, 0.01));
    }
}