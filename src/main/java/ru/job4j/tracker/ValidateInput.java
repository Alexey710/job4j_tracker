package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                if (value < 0 || value > 6) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            } catch (ArrayIndexOutOfBoundsException be) {
                System.out.println("Please enter number of menu from 0 to 6.");
            }
        } while (invalid);
        return value;
    }
}
