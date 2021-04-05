package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByNameTwo() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kirill", "Karnaukhov", "88005553535", "Arhangelsk")
        );
        ArrayList<Person> persons = phones.find("angel");
        assertThat(persons.get(0).getAddress(), is("Arhangelsk"));
    }

    @Test
    public void whenFindByNameThree() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kirill", "Karnaukhov", "88005553535", "Arhangelsk")
        );
        ArrayList<Person> persons = phones.find("lol");
        assertThat(persons.size(), is(0));
    }
}