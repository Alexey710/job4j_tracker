package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayViaFlatmap {
    public static List<Integer> transformer(Integer[][] array) {
        return Stream.of(array)
                .flatMap(Stream :: of)
                .collect(Collectors.toList());
    }
}
