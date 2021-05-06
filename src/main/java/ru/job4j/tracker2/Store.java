package ru.job4j.tracker2;

import java.util.List;

public interface Store extends AutoCloseable {
    void init();

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    void findAllReact(Output out);

    List<Item> findByName(String key);

    Item findById(String id);
}