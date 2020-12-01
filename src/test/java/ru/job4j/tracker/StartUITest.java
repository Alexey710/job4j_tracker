package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void createItem() {
        String[] answers = {"Item1", "Item2", "Item3"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < 3; i++) {
            StartUI.createItem(input, tracker);
        }
        Item created = tracker.findAll()[2];
        Item expected = new Item("Item3");
        assertThat(created.getName(), is(expected.getName()));
    }
}