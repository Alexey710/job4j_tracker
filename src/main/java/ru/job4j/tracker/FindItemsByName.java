package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Select \"name\" of Item:");
        List<Item> all = tracker.findByName(name);
        if (!all.isEmpty()) {
            for (Item elem : all) {
                out.println(elem);
            }
        } else {
            System.out.println("Name is not found.");
        }
        return true;
    }
}
