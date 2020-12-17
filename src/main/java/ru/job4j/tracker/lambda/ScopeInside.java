package ru.job4j.tracker.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        Integer[] number = {1, 2, 3};
            int total = add(number, (arr) -> {
                        int temp = 0;
                        for (int i = 0; i < arr.length; i++) {
                            temp = temp + arr[i];
                        }
                        return temp;
            });

        System.out.println(total);
    }

    private static Integer add(Integer[] arr, Function<Integer[], Integer> calc) {
        return calc.apply(arr);
    }
}