package ru.link.exercise02.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Изменяемый класс человека
 */
public class MutablePerson {

    /**
     * Имя
     */
    private String name;

    /**
     * Возраст
     */
    private int age;

    /**
     * Коллекция хобби
     */
    private ArrayList<String> hobbies;

    /**
     * Конструктор объекта человека
     * @param name Имя
     * @param age Возраст
     * @param hobbies Коллекция хобби
     */
    public MutablePerson(String name, int age, ArrayList<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    /**
     * Получение имени
     * @return Имя в виде строки
     */
    public String getName() {
        return name;
    }

    /**
     * Присвоение нового имени
     * @param name Новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение возраста
     * @return Возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Присвоение нового возраста
     * @param age Новый возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Получение коллекции хобби
     * @return Коллекция хобби
     */
    public List<String> getHobbies() {
        return hobbies;
    }

    /**
     * Добавление хобби в коллекцию
     * @param hobby Новое хобби
     */
    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        return name + ", " + age + " y.o.\n"
                + "Hobbies: " + hobbies + "\n";
    }
}
