package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void testDefaultCollect() {
        Profiles method = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Arbat", 1, 2)),
                new Profile(new Address("London", "Baker Street", 51, 1)),
                new Profile(new Address("Archangelsk", "Suvorov Street", 55, 100))
        );
        List<Address> rsl = method.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Archangelsk", "Suvorov Street", 55, 100));
        expected.add(new Address("London", "Baker Street", 51, 1));
        expected.add(new Address("Moscow", "Arbat", 1, 2));
        assertThat(rsl, is(expected));
    }

    @Test
    public void testAddSimpleAddress() {
        Profiles method = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Arbat", 1, 2)),
                new Profile(new Address("London", "Baker Street", 51, 1)),
                new Profile(new Address("Archangelsk", "Suvorov Street", 55, 100)),
                new Profile(new Address("Archangelsk", "Suvorov Street", 55, 100))
        );
        List<Address> rsl = method.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Archangelsk", "Suvorov Street", 55, 100));
        expected.add(new Address("London", "Baker Street", 51, 1));
        expected.add(new Address("Moscow", "Arbat", 1, 2));
        assertThat(rsl, is(expected));
    }

    @Test
    public void testAddSimpleCityName() {
        Profiles method = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Arbat", 1, 2)),
                new Profile(new Address("London", "Baker Street", 51, 1)),
                new Profile(new Address("Archangelsk", "Suvorov Street", 55, 100)),
                new Profile(new Address("Archangelsk", "Suvorov Street", 30, 10))
        );
        List<Address> rsl = method.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Archangelsk", "Suvorov Street", 55, 100));
        expected.add(new Address("Archangelsk", "Suvorov Street", 30, 10));
        expected.add(new Address("London", "Baker Street", 51, 1));
        expected.add(new Address("Moscow", "Arbat", 1, 2));
        assertThat(rsl, is(expected));
    }
}