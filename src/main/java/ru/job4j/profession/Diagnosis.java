package ru.job4j.profession;

public class Diagnosis {

    public static String firstDiagnos(Pacient pacient) {
        if (pacient.getAge() < 50) {
            return "Вы молоды";
        } else {
            return "Вы пожилой человек";
        }
    }
}
