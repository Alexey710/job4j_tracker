package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] all = tracker.findAll();
                for (Item elem : all) {
                    System.out.println(elem);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Select \"id\":");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Select \"name\" of а new Item:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                boolean validation = tracker.replace(id, item);
                if (validation) {
                    System.out.println("Item is replaced.");
                } else {
                    System.out.println("Item is not replaced.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Select \"id\":");
                int id = Integer.valueOf(scanner.nextLine());
                boolean validation = tracker.delete(id);
                if (validation) {
                    System.out.println("Item is deleted.");
                } else {
                    System.out.println("Item is not deleted.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Select \"id\":");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item is not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Select \"name\" of Item:");
                String name = scanner.nextLine();
                Item[] all = tracker.findByName(name);
                if (all.length > 0) {
                    for (Item elem : all) {
                        System.out.println(elem.getName());
                    }
                } else {
                    System.out.println("Name is not found.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println(
                " Menu:\n"
                + " 0. Add new Item\n"
                + " 1. Show all items\n"
                + " 2. Edit item\n"
                + " 3. Delete item\n"
                + " 4. Find item by Id\n"
                + " 5. Find items by name\n"
                + " 6. Exit Program\n"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
