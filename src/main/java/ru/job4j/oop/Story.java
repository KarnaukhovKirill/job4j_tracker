package ru.job4j.oop;

public class Story {

    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolf = new Wolf();
        girl.help(petya);
        wolf.tryEat(new Ball());
        petya.kill(wolf);
    }
}
