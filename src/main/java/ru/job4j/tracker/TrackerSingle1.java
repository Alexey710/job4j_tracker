package ru.job4j.tracker;

import java.util.Arrays;

public enum TrackerSingle1 {
    INSTANCE;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] namesEqualsKey = new Item[size];
        int index = 0;
        for (int i = 0; i < namesEqualsKey.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                namesEqualsKey[index] = items[i];
                index++;
            }
        }
        namesEqualsKey = Arrays.copyOf(namesEqualsKey, index);
        return namesEqualsKey;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
            items[index].setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, items.length - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Item item1 = new Item("Entry100");
        Item item2 = new Item("Entry200");
        TrackerSingle1.INSTANCE.add(item1);
        TrackerSingle1.INSTANCE.add(item2);
        System.out.println(Arrays.toString(INSTANCE.findAll()));
        System.out.println(Arrays.toString(INSTANCE.items));
    }
}
