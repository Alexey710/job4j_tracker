package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaLazyLoading {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator lengthCmp");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);

        String[] names1 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp1 = (left, right) -> {
            System.out.println("execute comparator lengthCmp1");
            return left.length() - right.length();
        };
        Arrays.sort(names1, lengthCmp1);
    }
}
