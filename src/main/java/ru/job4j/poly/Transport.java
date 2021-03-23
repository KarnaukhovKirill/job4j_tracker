package ru.job4j.poly;

public interface Transport {
    move();

    passenger(int count);

    double refuel(double fuel);
}
