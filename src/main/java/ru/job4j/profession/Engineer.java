package ru.job4j.profession;

public class Engineer extends Profession {

    private int experience;
    private char gender;

    public Engineer() {
        super();
    }

    public Engineer(int experience, char gender) {
        super();
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

    public Staff add(Client client) {
        //добавляет строителей исходя из заказа клиента
    }
}
