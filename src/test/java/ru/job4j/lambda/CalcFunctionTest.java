package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDoubleFunctionThenDoubleResults() {
        List<Double> result = CalcFunction.diapason(1, 3, x -> 5 * x * x + 3 * x + 2);
        List<Double> expected = Arrays.asList(10D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = CalcFunction.diapason(1, 6, x -> Math.pow(2D, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}