package ru.job4j.tracker2;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
