package ru.job4j.tracker;

public class ValidateRangeInput implements Input {
    private final Output out;
    private final ValidateInput in;
    private UserAction[] actions;

    public ValidateRangeInput(Output out, ValidateInput in, UserAction[] actions) {
        this.out = out;
        this.in = in;
        this.actions = actions;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                if (value < 0 || value >= actions.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                invalid = false;
            } catch (ArrayIndexOutOfBoundsException be) {
                out.println("Please enter number of menu from 0 to " + (actions.length - 1));
            }
        } while (invalid);
        return value;
    }

}
