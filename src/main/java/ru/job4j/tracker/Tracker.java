package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        for (int i = 1; i <= items.size() + 1; i++) {
            if (indexOf(i) == -1) {
                item.setId(i);
                break;
            }
        }
        if (items.size() == 0) {
            item.setId(1);
        }
        /*item.setId(ids++);*/
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
        return indexOf(id) == -1 ? null : items.get(indexOf(id));
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
                  replaced = items.remove(indexOf(id));
                break;
            }
        }
        return replaced != null;
    }
}