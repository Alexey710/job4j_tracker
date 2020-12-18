package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = new ArrayList<>();
        for (Student elem : students) {
            if (predict.test(elem)) {
                result.add(elem);
            }
        }
        return result;
    }
}
