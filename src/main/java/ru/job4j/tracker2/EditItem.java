package ru.job4j.tracker2;

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
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Select \"id\":");
        String name = input.askStr("Select \"name\" of а new Item:");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        String print = rsl ? "Item is replaced." : "Item is NOT replaced.";
        out.println(print);
        return true;
    }
}
