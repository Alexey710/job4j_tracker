package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
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
                if (value < 0 || value >= StartUI.getActions().length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            } catch (ArrayIndexOutOfBoundsException be) {
                out.println("Please enter number of menu from 0 to " + (StartUI.getActions().length - 1));
            }
        } while (invalid);
        return value;
    }

}
