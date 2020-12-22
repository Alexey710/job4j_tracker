package ru.job4j.stream.builder;

import java.util.List;

public class Spaceman {
    private String name;
    private int age;
    private int height;
    private int weight;
    private List<String> reward;
    private String gender;
    private String nationality;

    @Override
    public String toString() {
        return "Spaceman{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", height=" + height
                + ", weight=" + weight
                + ", reward=" + reward
                + ", gender='" + gender + '\''
                + ", nationality='" + nationality + '\''
                + '}';
    }

    static class Builder {
        private String name;
        private int age;
        private int height;
        private int weight;
        private List<String> reward;
        private String gender;
        private String nationality;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildHeight(int height) {
            this.height = height;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Builder buildReward(List<String> reward) {
            this.reward = reward;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        Spaceman build() {
            Spaceman spaceman = new Spaceman();
            spaceman.name = name;
            spaceman.age = age;
            spaceman.height = height;
            spaceman.weight = weight;
            spaceman.reward = reward;
            spaceman.gender = gender;
            spaceman.nationality = nationality;
            return spaceman;
        }
    }

    public static void main(String[] args) {
        Spaceman spaceman1 = new Builder()
                .buildName("Yuriy Gagarin")
                .buildAge(45)
                .buildGender("male")
                .buildNationality("USSR")
                .buildReward(List.of("Medal", "Order"))
                .build();
        Spaceman spaceman2 = new Builder()
                .buildName("Ivan Ivanov")
                .buildAge(35)
                .buildGender("male")
                .buildNationality("USSR")
                .buildReward(List.of())
                .build();
        System.out.println(spaceman1);
        System.out.println(spaceman2);
    }
}
