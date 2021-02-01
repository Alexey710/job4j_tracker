package ru.job4j.collection.departments;

import java.util.Comparator;

public class ComparatorDepartmentsDesnFirstElem implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] stringLeft = o1.split("/");
        String[] stringRight = o2.split("/");
        return stringRight[0].compareTo(stringLeft[0]);
    }

}
