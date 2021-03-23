package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху.");
    }

    @Override
    public int count() {
        return 40 + (int) (Math.random() * 250);
    }
}
