package ru.link.exercise04.task01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Russia");
        countries.add("Egypt");

        printCollection("Initial collection", countries);

        countries.add("Poland");
        countries.add("Japan");
        countries.add("Brazil");

        printCollection("After adding three countries", countries);

        countries.set(1, "Germany");
        printCollection("After replace", countries);

        countries.remove(1);
        printCollection("After remove by index", countries);

        countries.remove("Brazil");
        printCollection("After remove by value", countries);

        System.out.printf("Index of Japan is: %d\n", countries.indexOf("Japan"));

        System.out.printf("Is Brazil exists in collection? Answer: %s\n", countries.contains("Brazil"));
        System.out.printf("Is Russia exists in collection? Answer: %s\n", countries.contains("Russia"));
    }

    private static void printCollection(String message, List<?> collection) {
        System.out.print(message + ": ");
        System.out.println(collection);
    }
}
