package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item elem : items) {
            if (elem.getId() == id) {
                rsl = id - 1;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        for (Item elem : items) {
            if (elem.getId() == id) {
                return items.get(id - 1);
            }
        }
        return null;
    }

    public List<Item> findByName(String key) {
        List<Item> namesEqualsKey = new ArrayList<>();
        for (Item elem : items) {
            if (elem.getName().equals(key)) {
                namesEqualsKey.add(elem);
            }
        }
        return namesEqualsKey;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = -1;
        for (Item elem : items) {
            if (elem.getId() == id) {
                  index = id - 1;
            }
        }
        Item replaced;
        replaced = items.set(index, item);
        item.setId(id);
        if (replaced != null) {
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        Item replaced = null;
        for (Item elem : items) {
            if (elem.getId() == id) {
                  replaced = items.remove(id - 1);
                break;
            }
        }
        return replaced != null;
    }
}