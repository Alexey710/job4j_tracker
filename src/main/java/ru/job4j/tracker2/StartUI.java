package ru.job4j.tracker2;

import ru.job4j.tracker.StubOutput;

import java.sql.SQLException;
import java.util.List;

public class StartUI {
    private final List<UserAction> actions;
    private final Output out;
    private Store sqlTracker;

    public StartUI(Output out) {
        this.out = out;
        this.actions = List.of(
                new CreateItem(out), new EditItem(out), new DeleteItem(out),
                new ShowAllItems(out), new FindItemsByName(out), new FindItemById(out),
                new ExitProgram(out)
        );
        try {
            sqlTracker = new SqlTracker();
            sqlTracker.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void init(Input input) {
        boolean run = true;
        while (run) {
            this.showMenu(this.actions);
            int select = input.askInt("Select: ");
            UserAction action = this.actions.get(select);
            run = action.execute(input, sqlTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (UserAction elem : actions) {
            out.println(actions.indexOf(elem) + ". " + elem.name());
        }
    }

    private static void addOneBillionItems() {
        String[] answers = new String[2_000_100_001];
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                answers[i] = "0";
            } else {
                answers[i] = "Item" + i;
            }
        }
        answers[answers.length - 1] = "6";
        Output out = new ConsoleOutput();
        Input input = new StubInput(answers);
        new StartUI(out).init(input);
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ConsoleInput();
        new StartUI(out).init(input);
    }
}


