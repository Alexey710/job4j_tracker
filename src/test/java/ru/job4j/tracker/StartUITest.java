package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"6"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllItems() {
        String[] answers = {"0", "Item1", "0", "Item2", "0", "Item3", "1", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is(
                "Item{id=1, name='Item1}" + System.lineSeparator()
                        + "Item{id=2, name='Item2}" + System.lineSeparator()
                        + "Item{id=3, name='Item3}" + System.lineSeparator() + "===Exit Program==="
                        + System.lineSeparator()));
    }

    @Test
    public void whenFindItemsByName() {
        String[] answers = {"0", "Item1", "5", "Item1", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item{id=1, name='Item1}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemById() {
        String[] answers = {"0", "Item1", "0", "Item2", "2", "2", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item{id=2, name='Item2}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenDelete() {
        String[] answers = {"0", "Item1", "4", "1", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item is deleted." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidDelete() {
        String[] answers = {"0", "Item1", "4", "10", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item is not deleted." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenEditItem() {
        String[] answers = {"0", "Item1", "3", "1", "Item2", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item is replaced." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(output));
        actions.add(new ShowAllItems(output));
        actions.add(new FindItemById(output));
        actions.add(new EditItem(output));
        actions.add(new DeleteItem(output));
        actions.add(new FindItemsByName(output));
        actions.add(new ExitProgram(output));
        String[] answers = {"9", "6"};
        ValidateInput validateInput = new ValidateInput(output, new StubInput(answers));
        Input input = new ValidateRangeInput(output, validateInput, actions);
        Tracker tracker = new Tracker();

        new StartUI(output, actions).init(input, tracker);
        assertThat(output.toString(), is(
                String.format(
                        "Please enter number of menu from 0 to 6%n"
                                + "===Exit Program===%n"
                )
        ));
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(output));
        actions.add(new ShowAllItems(output));
        actions.add(new FindItemById(output));
        actions.add(new EditItem(output));
        actions.add(new DeleteItem(output));
        actions.add(new FindItemsByName(output));
        actions.add(new ExitProgram(output));
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput valid = new ValidateInput(output, in);
        int selected = valid.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output output = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(output));
        actions.add(new ShowAllItems(output));
        actions.add(new FindItemById(output));
        actions.add(new EditItem(output));
        actions.add(new DeleteItem(output));
        actions.add(new FindItemsByName(output));
        actions.add(new ExitProgram(output));
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] {"0", "Entry1", "0", "Entry2", "0", "Entry3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenNegativeInvalidInput() {
        Output output = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(output));
        actions.add(new ShowAllItems(output));
        actions.add(new FindItemById(output));
        actions.add(new EditItem(output));
        actions.add(new DeleteItem(output));
        actions.add(new FindItemsByName(output));
        actions.add(new ExitProgram(output));
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] {"-1", "0"}
        );
        Input input = new ValidateRangeInput(output, new ValidateInput(output, in), actions);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenInvalidEditItem() {
        String[] answers = {"0", "Item1", "0", "Item2", "3", "9", "2", "ItemReplaced", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item is not replaced." + System.lineSeparator()
                + "Item is replaced." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }
}