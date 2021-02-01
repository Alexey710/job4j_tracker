package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
            for (Map.Entry<String, Citizen> entry : citizens.entrySet()) {
                if (Objects.equals(entry.getKey(), passport)) {
                    return entry.getValue();
                }
            }
        return null;
    }
}
