package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenAdd() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenGet() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("911", "Donald Trump");
        Citizen citizen3 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen4 = new Citizen("567r", "Dima Krapivin");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        office.add(citizen2);
        office.add(citizen3);
        office.add(citizen4);
        assertThat(office.get("911"), is(citizen2));
    }

    @Test
    public void whenGetForAbsentEntry() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("911", "Donald Trump");
        Citizen citizen3 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen4 = new Citizen("567r", "Dima Krapivin");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        office.add(citizen2);
        office.add(citizen3);
        office.add(citizen4);
        assertThat(office.get("000"), is(nullValue()));
    }
}