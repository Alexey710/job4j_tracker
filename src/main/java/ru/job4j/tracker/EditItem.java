package ru.job4j.tracker;

public class EditItem implements UserAction {
    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean invalid = true;
        int id = -1;
        while (invalid) {
            id = input.askInt("Select \"id\":");
            if (tracker.findById(id) == null) {
                out.println("Item is not replaced.");
            } else {
                invalid = false;
            }
        }
        String name = input.askStr("Select \"name\" of а new Item:");
        Item item = new Item(name);
        boolean validation = tracker.replace(id, item);
        if (validation) {
                   out.println("Item is replaced.");
        } else {
                   out.println("Item is not replaced.");
        }
        return true;
    }
}
