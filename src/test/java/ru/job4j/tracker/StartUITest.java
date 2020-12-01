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

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Item item2 = new Item("new item2");
        tracker.add(item);
        tracker.add(item2);
        String[] answers = {
                Integer.toString(item.getId()), "replaced item", Integer.toString(item2.getId()), "replaced item2"
        };
        StubInput stubInput = new StubInput(answers);
        StartUI.editItem(stubInput, tracker);
        StartUI.editItem(stubInput, tracker);

        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
        Item replaced1 = tracker.findById(item2.getId());
        assertThat(replaced1.getName(), is("replaced item2"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();

        Item item = new Item("new item");
        Item item2 = new Item("new item2");

        tracker.add(item);
        tracker.add(item2);

        String[] answers = {
                Integer.toString(item.getId())};

        StubInput stubInput = new StubInput(answers);

        Item before = tracker.findAll()[0];
        assertThat(before.getName(), is("new item"));

        StartUI.deleteItem(stubInput, tracker);

        Item after = tracker.findAll()[0];
        assertThat(after.getName(), is("new item2"));
    }
}