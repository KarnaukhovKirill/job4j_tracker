package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void passenger(int count) {
        System.out.println("Автобус перевозит " + count + " пассажиров.");
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 70;
    }

}
