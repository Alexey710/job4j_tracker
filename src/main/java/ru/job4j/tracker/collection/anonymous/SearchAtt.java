package ru.job4j.tracker.collection.anonymous;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();

        Predicate<Attachment> predicate1 = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, predicate1);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();

        Predicate<Attachment> predicate2 = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, predicate2);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attachment : list) {
            if (predicate.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }
}
