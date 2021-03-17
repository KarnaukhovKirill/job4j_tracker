package ru.job4j.profession;

public class Programmer extends Engineer {

    private String language;

    public Programmer() {
        super();
    }

    public Programmer(String language) {
        super();
        this.language = language;
    }

    public int years(Client client) {
        //вывод сроков разработки
        return -1;
    }
}
