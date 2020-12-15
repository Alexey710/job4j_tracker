package ru.job4j.tracker.collection.departments;

import java.util.Comparator;

public class ComparatorDepartmentsAsc implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] stringLeft = o1.split("/");
        String[] stringRight = o2.split("/");
        int min = Integer.compare(stringLeft.length, stringRight.length) < 0
                ? stringLeft.length : stringRight.length;
        for (int i = 1; i < min; i++) {
            if (!stringLeft[i].equals(stringRight[i])) {
                return stringLeft[i].compareTo(stringRight[i]);
            }
        }
        return Integer.compare(stringLeft.length, stringRight.length);
    }
}