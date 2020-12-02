package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Item1", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(), new ShowAllItems(), new EditItem(),
                new DeleteItem(), new FindItemById(), new FindItemsByName(), new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Item1");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem0() {
        String[] answers = {"0", "Item1", "0", "Item2", "2", "1", "replaced Item1", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(), new ShowAllItems(), new EditItem(),
                new DeleteItem(), new FindItemById(), new FindItemsByName(), new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("replaced Item1");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        String[] answers = {"0", "Item1", "0", "Item2", "3", "1", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(), new ShowAllItems(), new EditItem(),
                new DeleteItem(), new FindItemById(), new FindItemsByName(), new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Item2");
        assertThat(created.getName(), is(expected.getName()));
    }

}