package ru.job4j.tracker;

public class StartUI {
    private static UserAction[] actions;
    private final Output out;
    
    public StartUI(Output out, UserAction[] actions) {
        this.out = out;
        StartUI.actions = actions;

    }

    public static UserAction[] getActions() {
        return actions;
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu(StartUI.actions);
            int select = input.askInt("Select: ");
            UserAction action = StartUI.actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        new StartUI(output, actions).init(input, tracker);
    }
}


