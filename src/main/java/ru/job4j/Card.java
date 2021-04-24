package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static class Desk {
        public static void main(String[] args) {
            List<Card> desk = Stream.of(Suit.values())
                    .flatMap(suit1 -> Stream.of(Value.values())
                            .map(value1 -> new Card(suit1, value1)))
                    .collect(Collectors.toList());
            desk.forEach(System.out::println);
        }
    }
}
