package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] charsLeft = left.toCharArray();
        char[] charsRight = right.toCharArray();
            for (int i = 0; i < charsLeft.length; i++) {
                if (charsLeft[i] != charsRight[i]) {
                    return charsLeft[i] > charsRight[i] ? 1 : -1;
                }
            }

        return charsLeft.length == charsRight.length ? 0 : charsLeft.length > charsRight.length ? 1 : -1;
    }
}
