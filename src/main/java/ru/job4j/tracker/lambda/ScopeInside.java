package ru.job4j.tracker.lambda;
import java.util.function.Function;

public class ScopeInside {
    public static int sum(Integer[] number) {
        return add(number, (arr) -> {
                        int temp = 0;
                        for (Integer elem : number) {
                            temp += elem;
                        }
                        return temp;
            });
    }

    private static Integer add(Integer[] arr, Function<Integer[], Integer> calc) {
        return calc.apply(arr);
    }
}