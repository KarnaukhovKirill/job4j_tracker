package ru.job4j.profession;

public class Pacient {

    private String name;
    private String surname;
    private int age;

    public Pacient() {
    }

    public Pacient(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
