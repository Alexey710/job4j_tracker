package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order elem : orders) {
            map.put(elem.getNumber(), elem);
            map.putIfAbsent(elem.getNumber(), elem);
        }
        return map;
    }
}
