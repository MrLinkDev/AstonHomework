package ru.link.exercise02.task02;

import java.util.ArrayList;
import java.util.List;

public class Runnable {
    public static void main(String[] args) {
        // Создаём неизменяемый экземпляр объекта человека
        ArrayList<String> bobHobbies = new ArrayList<>();
        bobHobbies.add("Football");
        bobHobbies.add("Fishing");

        ImmutablePerson immutablePerson = new ImmutablePerson(
                "Bob",
                20,
                bobHobbies);

        // Создаём изменяемый экземпляр объекта человека
        ArrayList<String> robHobbies = new ArrayList<>();
        robHobbies.add("Basketball");
        MutablePerson mutablePerson = new MutablePerson(
                "Rob",
                27,
                robHobbies);

        // Выводим состояние экземпляров до изменений
        System.out.println("Before changes:");
        System.out.println(immutablePerson);
        System.out.println(mutablePerson);

        // Изменяем состояние
        immutablePerson.setAge(21);
        immutablePerson.addHobby("Skiing");

        mutablePerson.setAge(28);
        mutablePerson.addHobby("Skiing");

        // Выводим состояние экземпляров после изменений
        System.out.println("After first changes:");
        System.out.println(immutablePerson);
        System.out.println(mutablePerson);

        // Изменяем состояние неизменяемого экземпляра и используем возвращаемое значение
        immutablePerson = immutablePerson.setAge(21);
        immutablePerson = immutablePerson.addHobby("Skiing");

        // Выводим состояние экземпляров после изменений
        System.out.println("After second changes:");
        System.out.println(immutablePerson);
        System.out.println(mutablePerson);
    }
}
