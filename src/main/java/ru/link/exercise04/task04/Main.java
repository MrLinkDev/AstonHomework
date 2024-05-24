package ru.link.exercise04.task04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(List.of(
                new Student("Bob", 128, 2),
                new Student("Rob", 129, 1),
                new Student("Tom", 127, 3),
                new Student("Ada", 128, 2)
                //new Student("Eva", 128, 2),
                //new Student("Kai", 128, 2),
                //new Student("Ivy", 126, 4),
                //new Student("Amy", 125, 5),
                //new Student("Lia", 125, 5),
                //new Student("Max", 125, 5)
        ));

        printCollection("Initial state", students);

        removeLosers(students);
        printCollection("After remove", students);

        printStudents(students, 1);
    }

    private static void removeLosers(ArrayList<Student> students) {
        students.removeIf(student -> student.getGradeAvg() < 3);
    }

    private static void printStudents(ArrayList<Student> students, int year) {
        String yearPart = Integer.toString(year);

        switch (year) {
            case 1  -> yearPart += "st";
            case 2  -> yearPart += "nd";
            case 3  -> yearPart += "rd";
            default -> yearPart += "th";
        }

        System.out.println(yearPart + "-year students:");

        for (Student student : students) {
            if (student.getYear() == year) {
                System.out.println(student.getName());
            }
        }
    }

    private static void printCollection(String message, List<Student> students) {
        System.out.println(message + ": ");

        for (Student student : students){
            System.out.println(student);
        }
    }
}
