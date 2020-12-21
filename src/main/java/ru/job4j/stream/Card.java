package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;
    private ColorCard color;

    public Card() {

    }

    public Card(Suit suit, Value value, ColorCard color) {
        this.suit = suit;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return suit + ":" + value + ":" + color;
    }

    List<String> createDeckString() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> suit + " " + value))
                .flatMap(x -> Stream.of(ColorCard.values())
                        .map(color -> x + " " + color))
                .collect(Collectors.toList());
    }

    List<Card> createDeckCard() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .flatMap(value -> Stream.of(ColorCard.values())
                                .map(color -> new Card(suit, value, color))))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Card().createDeckString());
        System.out.println(new Card().createDeckCard());

    }

}
