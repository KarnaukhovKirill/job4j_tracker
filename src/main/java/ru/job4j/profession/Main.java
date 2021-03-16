package ru.job4j.profession;

public class Main {

    public static void main(String[] args) {
        Pacient pervii = new Pacient("Kirill", "Karnaukhov", 25);
        System.out.println(Diagnosis.firstDia(pervii));
    }
}
