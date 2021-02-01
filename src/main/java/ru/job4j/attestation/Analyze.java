package ru.job4j.attestation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(List :: stream)
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0.00d);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(o -> new Tuple(o.getName(), o.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0.00d)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(List :: stream)
                .collect(Collectors.groupingBy(Subject::getName))
                .entrySet()
                .stream()
                .map(o -> new Tuple(o.getKey(), o.getValue()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0.00d)))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(o -> new Tuple(o.getName(), o.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .collect(Collectors.toList())
                .stream().max(Comparator.comparing(Tuple::getScore))
                .get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(List :: stream)
                .collect(Collectors.groupingBy(Subject::getName))
                .entrySet()
                .stream()
                .map(o -> new Tuple(o.getKey(), o.getValue()
                .stream()
                .mapToInt(Subject::getScore)
                .sum())).collect(Collectors.toList())
                .stream()
                .max(Comparator.comparing(Tuple::getScore))
                .get();
    }
}