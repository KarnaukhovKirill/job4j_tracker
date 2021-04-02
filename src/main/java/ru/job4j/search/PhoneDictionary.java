package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person a : persons) {
            if (a.getName().contains(key) || a.getSurname().contains(key)
                    || a.getPhone().contains(key) || a.getAddress().contains(key)) {
                result.add(a);
            }
        }
        return result;
    }
}
