package ru.job4j.tracker.collection;

import java.util.Comparator;
import java.util.Objects;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] charsLeft = left.split("\\.");
        String[] charsRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(charsLeft[0]), Integer.parseInt(charsRight[0]));
    }
}
