package ru.link.exercise04.task02;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<>(List.of("Germany", "Spain", "Hungary"));
        printCollection("Initial state", countries);

        countries.addFirst("Ecuador");
        countries.addFirst("Switzerland");

        countries.addLast("Vietnam");
        countries.addLast("Taiwan");

        printCollection("After adding", countries);

        countries.removeFirst();
        countries.removeLast();

        printCollection("After removing", countries);

        System.out.printf("Element at the beginning: %s\n", countries.getFirst());
        System.out.printf("Element at the end: %s\n", countries.getLast());
    }

    private static void printCollection(String message, List<?> collection) {
        System.out.print(message + ": ");
        System.out.println(collection);
    }
}
