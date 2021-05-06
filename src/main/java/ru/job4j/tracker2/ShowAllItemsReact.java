package ru.job4j.tracker2;

import java.util.List;

public class ShowAllItemsReact implements UserAction {
    private final Output out;

    public ShowAllItemsReact(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items (react) ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        tracker.findAllReact(out);
        return true;
    }
}
