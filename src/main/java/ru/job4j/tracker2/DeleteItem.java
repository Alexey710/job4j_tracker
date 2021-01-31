package ru.job4j.tracker2;

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
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Select \"id\":");
        String print = tracker.delete(id) ? "Item is deleted." : "Item is NOT deleted.";
        out.println(print);
        return true;
    }
}
