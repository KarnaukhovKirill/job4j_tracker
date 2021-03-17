package ru.job4j.profession;

public class Dentist extends Doctor {

    private String specialization;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday, int experience, char gender, String specialization) {
        super(name, surname, education, birthday, experience, gender);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean delTooth(Pacient pacient) {
        return true;
    }
}
