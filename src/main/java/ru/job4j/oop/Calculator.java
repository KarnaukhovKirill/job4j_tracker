package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(10));
        System.out.println(minus(10));
        System.out.println(calculator.multiply(10));
        System.out.println(calculator.divide(10));
        var sumAllOperation = calculator.sumAllOperation(10);
        System.out.println(sumAllOperation);
    }
}
