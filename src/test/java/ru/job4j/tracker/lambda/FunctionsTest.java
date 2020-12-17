package ru.job4j.tracker.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;


public class FunctionsTest {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (double i = start; i < end; i++) {
            list.add(func.apply(i));
        }
        return list;
    }

    @Test
    public void whenLinearFunction() {
        List<Double> result = FunctionsTest.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionsTest.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FunctionsTest.diapason(5, 8, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(3125D, 15625D, 78125D);
        Assert.assertThat(result, is(expected));
    }
}