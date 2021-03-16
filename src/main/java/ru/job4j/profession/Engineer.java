package ru.job4j.profession;

public class Engineer extends Profession {

    private int experience;
    private char gender;

    public Engineer() {
    }

    public Engineer(String name, String surname, char gender, String birthday, int experience) {
        this.setName(name);
        this.setSurname(surname);
        this.gender = gender;
        this.setBirthday(birthday);
        this.experience = experience;
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
