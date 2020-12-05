package ru.job4j.tracker;

public class StartUI {
    private final UserAction[] actions;
    private final Output out;
    
    public StartUI(Output out, UserAction[] actions) {
        this.out = out;
        this.actions = actions;

    }

    public UserAction[] getActions() {
        return actions;
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu(this.actions);
            int select = input.askInt("Select: ");
            UserAction action = this.actions[select];
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
        UserAction[] actions = {
                new CreateItem(output), new ShowAllItems(output), new EditItem(output),
                new DeleteItem(output), new FindItemById(output), new FindItemsByName(output), new ExitProgram(output)
        };
        Input input = new ValidateRangeInput(output, new ValidateInput(output, new ConsoleInput()), actions);
        Tracker tracker = new Tracker();
        new StartUI(output, actions).init(input, tracker);
    }
}


