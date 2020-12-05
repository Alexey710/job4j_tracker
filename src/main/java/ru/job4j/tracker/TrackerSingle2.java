package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingle2 {
    private static Tracker instance;

    private TrackerSingle2() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return instance.add(item);
    }

    public Item findById(int id) {
        return instance.findById(id);
    }

    public Item[] findByName(String key) {
        return instance.findByName(key);
    }

    public Item[] findAll() {
        return instance.findAll();
    }

    public boolean replace(int id, Item item) {
        return instance.replace(id, item);
    }

    public boolean delete(int id) {
        return instance.delete(id);
    }

    public static void main(String[] args) {
        Tracker instance1 = TrackerSingle2.getInstance();
        Tracker instance2 = TrackerSingle2.getInstance();
        Item item1 = new Item("Entry100");
        Item item2 = new Item("Entry200");
        instance1.add(item1);
        instance2.add(item2);
        System.out.println(Arrays.toString(instance1.findAll()));
        System.out.println(Arrays.toString(instance2.findAll()));
        System.out.println(instance1 == instance2);
    }
}
