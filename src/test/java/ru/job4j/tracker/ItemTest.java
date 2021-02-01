package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ComparatorItemReverseOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void sortItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3));
        items.add(new Item(2));
        items.add(new Item(1));
        items.add(new Item(4));
        Collections.sort(items);
        List<Item> expected = List.of(new Item(1), new Item(2), new Item(3), new Item(4));
        Assert.assertEquals(expected, items);
    }

    @Test
    public void reverseSortItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3));
        items.add(new Item(2));
        items.add(new Item(1));
        items.add(new Item(4));
        Collections.sort(items, new ComparatorItemReverseOrder());
        List<Item> expected = List.of(new Item(4), new Item(3), new Item(2), new Item(1));
        Assert.assertEquals(expected, items);
    }
}