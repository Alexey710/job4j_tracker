package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    List<Profile> profiles = new ArrayList<>();
    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Tula", "Svetlay", 18, 477)));
        profiles.add(new Profile(new Address("Tula", "Svetlay", 18, 477)));
        profiles.add(new Profile(new Address("Tula", "Svetlay", 18, 477)));
        profiles.add(new Profile(new Address("Penza", "Pushkina", 8, 454)));
        profiles.add(new Profile(new Address("Moscow", "Lenina", 1, 144)));

    }

    @Test
    public void whenCollect() {
        List<Address> expected = List.of(
                new Address("Moscow", "Lenina", 1, 144),
                new Address("Penza", "Pushkina", 8, 454),
                new Address("Tula", "Svetlay", 18, 477)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        Assert.assertThat(rsl, is(expected));

    }
}