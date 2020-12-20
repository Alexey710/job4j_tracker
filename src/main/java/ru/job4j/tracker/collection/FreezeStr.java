package ru.job4j.tracker.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] leftArr = left.split("");
        String[] rightArr = right.split("");
        Arrays.sort(leftArr);
        Arrays.sort(rightArr);
        for (int i = 0; i < left.length(); i++) {
            if (!leftArr[i].equals(rightArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq2(String left, String right, String splitter) {
        String[] leftArr = left.split(splitter);
        String[] rightArr = right.split(splitter);
        Map<String, Integer> leftMap = new HashMap<>();
        Map<String, Integer> rightMap = new HashMap<>();
        for (String elem : leftArr) {
           if (leftMap.containsKey(elem)) {
               leftMap.computeIfPresent(elem, (key, val) -> val + 1);
           } else {
               leftMap.put(elem, 1);
           }
        }

        for (String elem : rightArr) {
            if (rightMap.containsKey(elem)) {
                rightMap.computeIfPresent(elem, (key, val) -> val + 1);
            } else {
                rightMap.put(elem, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : leftMap.entrySet()) {
            if (!rightMap.containsKey(entry.getKey()) || rightMap.get(entry.getKey()) != leftMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}