package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Select \"id\":");
        boolean validation = tracker.delete(id);
        if (validation) {
            out.println("Item is deleted.");
        } else {
            out.println("Item is not deleted.");
        }
        return true;
    }
}
