package ru.job4j.tracker2;

import java.util.List;

public class FindItemsByName implements UserAction {
    private final Output out;

    public FindItemsByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Select \"name\" of Item:");
        List<Item> all = tracker.findByName(name);
        String print = all.size() > 0 ? "Item is found: " : "Item is NOT found: ";
        System.out.println(print);
        for (Item elem : all) {
            out.println(elem);
        }
        return true;
    }
}
