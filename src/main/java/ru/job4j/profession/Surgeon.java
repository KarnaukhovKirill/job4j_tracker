package ru.job4j.profession;

public class Surgeon extends Doctor {

    private String specialization;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, String birthday, int experience, char gender, String specialization) {
        super(name, surname, education, birthday, experience, gender);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Diagnosis operation(Pacient pacient) {
    }
}
