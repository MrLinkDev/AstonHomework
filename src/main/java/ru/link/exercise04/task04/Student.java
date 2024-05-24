package ru.link.exercise04.task04;

import java.util.Arrays;
import java.util.Random;

public class Student {

    private final int GRADE_COUNT = 20;

    /**
     * Имя
     */
    private String name;
    /**
     * Группа
     */
    private int group;
    /**
     * Курс
     */
    private int year;
    /**
     * Оценки
     */
    private int[] grades;

    public Student(String name, int group, int year) {
        this.name = name;
        this.group = group;
        this.year = year;

        generateGrades();
    }

    private void generateGrades() {
        Random random = new Random();

        grades = new int[GRADE_COUNT];
        for (int i = 0; i < GRADE_COUNT; ++i) {
            grades[i] = random.nextInt(1, 6);
        }
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public int getYear() {
        return year;
    }

    public float getGradeAvg() {
        float gradeAvg = 0;

        for (int grade : grades) {
            gradeAvg += grade;
        }

        gradeAvg /= GRADE_COUNT;

        return gradeAvg;
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n" +
                "\tGroup: " + group + "\n" +
                "\tYear: " + year + "\n" +
                "\tGrade avg: " + getGradeAvg() + "\n" +
                "\tGrades: " + Arrays.toString(grades) + "\n";
    }
}
