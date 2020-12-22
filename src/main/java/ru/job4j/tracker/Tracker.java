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
        int index = -1;
        for (Item elem : items) {
            index++;
            if (elem.getId() == id) {
                return index;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items.get(index);
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
        int index = indexOf(id);
        Item replaced;
        if (index != -1) {
            replaced = items.set(index, item);
            item.setId(id);
            if (replaced != null) {
                rsl = true;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        Item replaced = null;
        int index = indexOf(id);
        if (index != -1) {
            for (Item elem : items) {
                if (elem.getId() == id) {
                    replaced = items.remove(index);
                    break;
                }
            }
        }

        return replaced != null;
    }
}