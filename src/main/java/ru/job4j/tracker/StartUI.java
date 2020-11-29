package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime date = new Item().getCreated();

        System.out.println(date.format(formatter));

        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("new title");
        tracker.add(item1);
        System.out.println(tracker.findById(1));

    }
}
