package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ArrayViaFlatmapTest {

    @Test
    public void transformer() {
        Integer[][] arr = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> output = ArrayViaFlatmap.transformer(arr);
        Assert.assertThat(output, is(expected));
    }
}