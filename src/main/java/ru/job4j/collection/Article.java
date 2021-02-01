package ru.job4j.collection;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.replaceAll(",", "")
                .replaceAll("\\.", "")
                .replaceAll("!", "")
                .replaceAll(":", "")
                .replaceAll(";", "");

        String[] originArr = origin.split(" ");
        String[] lineArr = line.split(" ");
        int count = 0;
        for (String line1 : lineArr) {
            for (String origin1 : originArr) {
                if (line1.equals(origin1)) {
                    count++;
                    break;
                }
            }
        }
        return lineArr.length == count;
    }
}