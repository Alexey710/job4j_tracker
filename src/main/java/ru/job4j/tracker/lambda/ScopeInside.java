package ru.job4j.tracker.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class ScopeInside {
    public static int sum(Integer[] number) {
            int total = add(number, (arr) -> {
                        int temp = 0;
                        for (int i = 0; i < arr.length; i++) {
                            temp = temp + arr[i];
                        }
                        return temp;
            });
            return total;
    }

    private static Integer add(Integer[] arr, Function<Integer[], Integer> calc) {
        return calc.apply(arr);
    }
}