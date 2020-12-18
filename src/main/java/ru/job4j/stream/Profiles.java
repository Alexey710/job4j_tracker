package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comp = (a, b) -> a.getCity().compareTo(b.getCity());
        return profiles.stream().map(Profile :: getAddress).distinct().sorted(comp).collect(Collectors.toList());
    }
}
