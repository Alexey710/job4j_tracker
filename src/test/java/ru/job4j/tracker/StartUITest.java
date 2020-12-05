package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"6"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllItems() {
        String[] answers = {"0", "Item1", "0", "Item2", "0", "Item3", "1", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
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
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item{id=1, name='Item1}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemById() {
        String[] answers = {"0", "Item1", "0", "Item2", "4", "2", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item{id=2, name='Item2}" + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator() ));
    }

    @Test
    public void whenDelete() {
        String[] answers = {"0", "Item1", "3", "1", "1", "6"};
        Output output = new StubOutput();
        Input in = new StubInput(answers);

        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        new StartUI(output, actions).init(in, tracker);
        assertThat(output.toString(), is("Item is deleted." + System.lineSeparator()
                + "===Exit Program===" + System.lineSeparator() ));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        String[] answers = {"9", "6"};
        Input input = new ValidateRangeInput(output, new ValidateInput(output, new StubInput(answers)), actions);
        Tracker tracker = new Tracker();

        new StartUI(output, actions).init(input, tracker);
        assertThat(output.toString(), is(
                String.format(
                        "Please enter number of menu from 0 to 6" + System.lineSeparator()
                                + "===Exit Program===" + System.lineSeparator()
                )
        ));
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] { "1"}
        );
        ValidateInput valid = new ValidateInput(output, in);
        int selected = valid.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] { "0", "Entry1", "0", "Entry2", "0", "Entry3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenNegativeInvalidInput() {
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        StartUI startUI = new StartUI(output, actions);
        Input in = new StubInput(
                new String[] { "-1", "0"}
        );
        Input input = new ValidateRangeInput(output, new ValidateInput(output, in), actions);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }
}