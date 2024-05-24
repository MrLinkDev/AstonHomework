package ru.link.exercise04.task03;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashSet<Person> personHashSet = new HashSet<>();

        Person bob = new Person("Bob", 20);
        Person rob = new Person("Rob", 30);
        Person tom = new Person("Tom", 47);

        personHashSet.add(bob);
        personHashSet.add(rob);
        personHashSet.add(tom);

        printPersonHashSet("Initial state", personHashSet);

        personHashSet.remove(rob);
        personHashSet.remove(tom);

        printPersonHashSet("After remove", personHashSet);
    }

    private static void printPersonHashSet(String message, Set<Person> set) {
        System.out.println(message + ": ");

        for (Person person : set) {
            System.out.printf("\t- %s (%d)\n", person.getName(), person.getAge());
        }
    }
}
