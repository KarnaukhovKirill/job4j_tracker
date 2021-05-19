package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {
    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double subAndDivide(double first, double second) {
        return subtraction(first, second)
                + divide(first, second);
    }

    public static double sumOfAllMethod(double first, double second) {
        return sumAndMultiply(first, second)
                + subAndDivide(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчёта sumAndMultiply равен: " + sumAndMultiply(10, 20));
        System.out.println("Результат расчёта subAndDivide равен: " + subAndDivide(10, 20));
        System.out.println("Результат расчёта sumAllMethod равен: " + sumOfAllMethod(10, 20));
    }
}
