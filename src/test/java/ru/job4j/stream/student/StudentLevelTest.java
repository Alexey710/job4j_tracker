package ru.job4j.stream.student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenUnsorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Misha", 20));
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        input.add(new Student("Vova", 19));
        List<Student> expected = List.of(
                new Student("Masha", 28),
                new Student("Pety", 128)
        );
        List<Student> output = StudentLevel.levelOf(input, 20);
        assertThat(output, is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student("Pety", 28));
        List<Student> expected = List.of(new Student("Pety", 28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }

    @Test
    public void whenUnsortedAndHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Misha", 20));
        input.add(new Student("Masha", 28));
        input.add(null);
        input.add(new Student("Pety", 128));
        input.add(new Student("Vova", 19));
        List<Student> expected = List.of(
                new Student("Masha", 28),
                new Student("Pety", 128)
        );
        List<Student> output = StudentLevel.levelOf(input, 20);
        assertThat(output, is(expected));

    }
}