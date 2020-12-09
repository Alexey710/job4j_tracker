package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final List<UserAction> actions;
    private final Output out;
    
    public StartUI(Output out, List<UserAction> actions) {
        this.out = out;
        this.actions = actions;

    }

    public List<UserAction> getActions() {
        return actions;
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu(this.actions);
            int select = input.askInt("Select: ");
            UserAction action = this.actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (UserAction elem : actions) {
            System.out.println(actions.indexOf(elem) + ". " + elem.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>();
        actions = List.of(
                new CreateItem(output), new ShowAllItems(output), new FindItemById(output),
                new EditItem(output), new DeleteItem(output), new FindItemsByName(output),
                new ExitProgram(output)
        );

        Input input = new ValidateRangeInput(output, new ValidateInput(output, new ConsoleInput()), actions);
        Tracker tracker = new Tracker();
        new StartUI(output, actions).init(input, tracker);
    }
}


