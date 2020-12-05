package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingle3 {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingle3() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return INSTANCE.add(item);
    }

    public Item findById(int id) {
        return INSTANCE.findById(id);
    }

    public Item[] findByName(String key) {
        return INSTANCE.findByName(key);
    }

    public Item[] findAll() {
        return INSTANCE.findAll();
    }

    public boolean replace(int id, Item item) {
        return INSTANCE.replace(id, item);
    }

    public boolean delete(int id) {
        return INSTANCE.delete(id);
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle3.getInstance();
    }
}
