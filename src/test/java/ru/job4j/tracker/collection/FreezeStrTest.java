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

    @Test
    public void whenEq2() {
        boolean rsl = FreezeStr.eq2("Hello", "Hlloe", "");
        assertThat(rsl, is(true));
    }

    @Test
    public void whenNotEq2() {
        assertThat(FreezeStr.eq2("Hello", "Halle", ""), is(false));
    }

    @Test
    public void whenNotMultiEq2() {
        assertThat(FreezeStr.eq2("heloo", "hello", ""), is(false));
    }

    @Test
    public void whenNotMultiWordsEq2() {
        assertThat(FreezeStr.eq2("мама мыла раму", "мама мама мама мыла", " "), is(false));
    }
}