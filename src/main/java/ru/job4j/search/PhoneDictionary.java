package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containName = f -> f.getName().contains(key);
        Predicate<Person> containSurname = f -> f.getSurname().contains(key);
        Predicate<Person> containPhone = f -> f.getPhone().contains(key);
        Predicate<Person> containAddress = f -> f.getAddress().contains(key);
        Predicate<Person> combine =  containName
                .or(containSurname)
                .or(containPhone)
                .or(containAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
/*
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person a : persons) {
            if (a.getName().contains(key) || a.getSurname().contains(key)
                    || a.getPhone().contains(key) || a.getAddress().contains(key)) {
                result.add(a);
            }
        }
        return result;

 */
    }

