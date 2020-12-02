package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Select \"id\":");
        boolean validation = tracker.delete(id);
        if (validation) {
            System.out.println("Item is deleted.");
        } else {
            System.out.println("Item is not deleted.");
        }
        return true;
    }
}
