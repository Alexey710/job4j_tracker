package ru.job4j.tracker.lambda;

import ru.job4j.tracker.collection.anonymous.Attachment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Checkout {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 150),
                new Attachment("bug", 100),
                new Attachment("image 2", 34),
                new Attachment("bug", 13)
        );
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare length: " +  right.getName() + ":" + left.getName());
            return right.getName().length() - left.getName().length();
        };
        Collections.sort(attachments, cmpDescSize);
    }
}
