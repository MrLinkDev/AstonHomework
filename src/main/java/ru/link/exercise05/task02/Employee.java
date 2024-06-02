package ru.link.exercise05.task02;

public record Employee(String name, int age, String department, int salary) {

    @Override
    public String toString() {
        return "{" + name + ", " + age + ", " + department + ", " + salary + "}";
    }
}
