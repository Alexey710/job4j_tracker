package ru.job4j.tracker.collection.departments;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = null;
            for (String el : value.split("/")) {
                if (start == null) {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator<String> then = new ComparatorDepartmentsAsc();
        Comparator<String> comb =
                new ComparatorDepartmentsDesnFirstElem().thenComparing(then);
        Collections.sort(orgs, comb);
    }
}
