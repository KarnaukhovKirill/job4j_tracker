package ru.job4j.pojo;

public class Book {

    private String name;
    private int nPage;

    public Book() {
    }

    public Book(String name, int nPage) {
        this.name = name;
        this.nPage = nPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnPage() {
        return nPage;
    }

    public void setnPage(int nPage) {
        this.nPage = nPage;
    }
}
