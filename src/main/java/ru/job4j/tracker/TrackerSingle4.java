package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingle4 {
    private TrackerSingle4() {
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return Holder.INSTANCE.add(item);
    }

    public Item findById(int id) {
        return Holder.INSTANCE.findById(id);
    }

    public Item[] findByName(String key) {
        return Holder.INSTANCE.findByName(key);
    }

    public Item[] findAll() {
        return Holder.INSTANCE.findAll();
    }

    public boolean replace(int id, Item item) {
        return Holder.INSTANCE.replace(id, item);
    }

    public boolean delete(int id) {
        return Holder.INSTANCE.delete(id);
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle4.getInstance();
    }
}
