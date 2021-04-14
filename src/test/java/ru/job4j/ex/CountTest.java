package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Count.add(10,2);
    }

    @Test
    public void whenThreeTo5() {
        assertThat(Count.add(3, 5), is(7));
    }
}