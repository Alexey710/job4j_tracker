package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] all = tracker.findAll();
        for (Item elem : all) {
            System.out.println(elem);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Select \"id\":");
        String name = input.askStr("Select \"name\" of а new Item:");
        Item item = new Item(name);
        boolean validation = tracker.replace(id, item);
        if (validation) {
            System.out.println("Item is replaced.");
        } else {
            System.out.println("Item is not replaced.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Select \"id\":");
        boolean validation = tracker.delete(id);
        if (validation) {
            System.out.println("Item is deleted.");
        } else {
            System.out.println("Item is not deleted.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("Select \"id\":");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item is not found.");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Select \"name\" of Item:");
        Item[] all = tracker.findByName(name);
        if (all.length > 0) {
            for (Item elem : all) {
                System.out.println(elem);
            }
        } else {
            System.out.println("Name is not found.");
        }
    }
    
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                 StartUI.createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
