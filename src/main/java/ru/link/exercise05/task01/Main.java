package ru.link.exercise05.task01;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    private static final SimpleLogger simpleLogger = (m, c) -> System.out.println(m + ": " + c);

    public static void main(String[] args) {
        ArrayList<Integer> collection = generateCollection(20);
        simpleLogger.print("Initial state", collection);

        collection = (ArrayList<Integer>) collection.stream()
                .distinct()
                .collect(Collectors.toList());
        simpleLogger.print("After .distinct()", collection);

        collection = (ArrayList<Integer>) collection.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
        simpleLogger.print("After removing odd numbers", collection);

        int sum = collection.stream().reduce((i1, i2) -> i1 + i2).orElse(0);
        System.out.println("Sum of elements: " + sum);
    }

    private static ArrayList<Integer> generateCollection(int size) {
        ArrayList<Integer> collection = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; ++i) {
            collection.add(random.nextInt(1, 10));
        }

        return collection;
    }
}

interface SimpleLogger {
    void print(String message, ArrayList<Integer> collection);
}
