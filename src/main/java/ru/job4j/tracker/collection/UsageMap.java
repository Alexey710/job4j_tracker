package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("info22@yandex.ru", "Ivan Ivanov");
        map.put("batman@mail.ru", "Vladimir Vladimirovich");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}