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
}