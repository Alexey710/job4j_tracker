package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = a -> a.getPhone().equals(key);
        Predicate<Person> address = a -> a.getAddress().equals(key);
        Predicate<Person> name = a -> a.getName().equals(key);
        Predicate<Person> surname = a -> a.getSurname().equals(key);
        Predicate<Person> combine = phone.or(address).or(name).or(surname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}