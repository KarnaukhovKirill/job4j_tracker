package ru.job4j.profession;

public class Doctor extends Profession {

    private int experience;
    private char gender;

    public Doctor() {
    }

    public Doctor(String name, String surname, String birthday, int experience, char gender) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthday(birthday);
        this.experience = experience;
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public char getGender() {
        return gender;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String heal(Pacient pacient) {
        return Diagnosis.firstDiagnos(pacient);
    }
}
