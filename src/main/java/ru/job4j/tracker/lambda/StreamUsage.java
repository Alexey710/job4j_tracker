package ru.job4j.tracker.lambda;

import java.util.List;
import java.util.Objects;

public class StreamUsage {
    public static class Task {

        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        public String getName() {
            return name;
        }

        public long getSpent() {
            return spent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Task task = (Task) o;
            return spent == task.spent && Objects.equals(name, task.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, spent);
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}
