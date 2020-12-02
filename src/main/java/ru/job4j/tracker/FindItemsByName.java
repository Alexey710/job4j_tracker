package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Select \"name\" of Item:");
        Item[] all = tracker.findByName(name);
        if (all.length > 0) {
            for (Item elem : all) {
                System.out.println(elem);
            }
        } else {
            System.out.println("Name is not found.");
        }
        return true;
    }
}
