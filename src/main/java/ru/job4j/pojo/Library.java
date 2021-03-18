package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book one = new Book("It", 335);
        Book two = new Book("Clean code", 1);
        Book three = new Book("Think about me", 150);
        Book four = new Book("Yesterday i'll be there", 56);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int index = 0; index < books.length; index++) {
            Book i = books[index];
            System.out.println(i.getName() + " " + i.getnPage());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int index = 0; index < books.length; index++) {
            Book i = books[index];
            System.out.println(i.getName() + " " + i.getnPage());
        }
        for (int index = 0; index < books.length; index++) {
            Book i = books[index];
            if (i.getName().equals("Clean code")) {
                System.out.println(i.getName() + " " + i.getnPage());
            }
        }
    }
}
