package ru.job4j.poly;

public interface Transport {
    void move();

    void passenger(int count);

    double refuel(double fuel);
}
