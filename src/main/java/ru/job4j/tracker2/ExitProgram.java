package ru.job4j.tracker2;

public class ExitProgram implements UserAction {
    private final Output out;

    public ExitProgram(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "===Exit Program===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("Program is completed.");
        return false;
    }
}
