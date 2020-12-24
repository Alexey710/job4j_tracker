package ru.job4j.tracker.lambda;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ScopeInsideTest {

    @Test
    public void whenSum() {
        Integer[] number = {1, 2, 3};
        int output = ScopeInside.sum(number);
        Assert.assertThat(output, is(6));
    }

    @Test
    public void whenSumEqualsZero() {
        Integer[] number = {};
        int output = ScopeInside.sum(number);
        Assert.assertThat(output, is(0));
    }
}