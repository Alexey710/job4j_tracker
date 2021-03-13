package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUIMockTest {
    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0 , 5, 6);
        when(input.askStr(any(String.class))).thenReturn("Item1");
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(input, tracker);
        assertThat(output.toString(), is("Item{id=1, name='Item1}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0, 0, 2, 2, 6);
        when(input.askStr(any(String.class))).thenReturn("Item1", "Item2");
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(input, tracker);
        assertThat(output.toString(), is("Item{id=2, name='Item2}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenDelete() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0, 4, 1, 6);
        when(input.askStr(any(String.class))).thenReturn("Item1");
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(input, tracker);
        assertThat(output.toString(), is("Item is deleted." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

}