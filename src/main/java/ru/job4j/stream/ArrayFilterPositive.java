package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFilterPositive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-9);
        list.add(0);
        List<Integer> listPositive  = list.stream().filter(n -> n > 0)
                .collect(Collectors.toList());
    }

}
