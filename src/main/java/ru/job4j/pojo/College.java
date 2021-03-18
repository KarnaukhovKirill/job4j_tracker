package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Vladimir Vladimirovich Utin");
        student.setGroup(2);
        student.setDate("25.12.1999");
        System.out.println("Фио: " + student.getFio() + System.lineSeparator()
                            + "Группа: " + student.getGroup() + System.lineSeparator()
                            + "Дата рождения: " + student.getDate());
    }
}
