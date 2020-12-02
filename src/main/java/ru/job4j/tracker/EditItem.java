package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Select \"id\":");
        String name = input.askStr("Select \"name\" of а new Item:");
        Item item = new Item(name);
        boolean validation = tracker.replace(id, item);
        if (validation) {
            System.out.println("Item is replaced.");
        } else {
            System.out.println("Item is not replaced.");
        }
        return true;
    }
}
