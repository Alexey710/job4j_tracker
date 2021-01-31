package ru.job4j.tracker2;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Select \"id\":");
        Item item = tracker.findById(id);
        String print = item != null ? "Item is found: " : "Item is NOT found: ";
        out.println(print);
        out.println(item);
        return true;
    }
}
