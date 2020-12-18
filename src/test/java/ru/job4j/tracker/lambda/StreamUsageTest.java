package ru.job4j.tracker.lambda;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;

public class StreamUsageTest {

    @Test
    public void whenFilterGreaterThen() {
        List<StreamUsage.Task> tasks = List.of(
                new StreamUsage.Task("Bug #1", 10),
                new StreamUsage.Task("Task #2", 20),
                new StreamUsage.Task("Bug #3", 40)
        );
        List<StreamUsage.Task> expected = List.of(
                new StreamUsage.Task("Bug #3", 40)
        );
        List<StreamUsage.Task> output = tasks.stream()
                .filter(task -> task.getName().contains("Bug"))
                .filter(task -> task.getSpent() > 30)
                .collect(Collectors.toList()
                );
        Assert.assertThat(output, is(expected));
    }

}