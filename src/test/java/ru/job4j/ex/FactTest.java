package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThenZero() {
        Fact.calc(-5);
    }

    @Test
    public void whenNEqualFive() {
        assertThat(Fact.calc(5), is(120));
    }
}