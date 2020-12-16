package ru.job4j.tracker.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        boolean rsl = FreezeStr.eq("Hello", "Hlloe");
        assertThat(rsl, is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }
}