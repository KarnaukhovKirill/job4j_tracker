package ru.job4j.poly;

public class PolyUsage {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[] {bus, plane, train};
        for (Vehicle v : vehicles) {
            v.move();
            System.out.println("И может перевести до " + v.count() + " пассажиров.");
            System.out.println();
        }
    }
}
