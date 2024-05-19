package ru.link.exercise02.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Неизменяемый класс человека
 */
public final class ImmutablePerson {

    /**
     * Имя
     */
    private final String name;

    /**
     * Возраст
     */
    private final int age;

    /**
     * Коллекция хобби
     */
    private final ArrayList<String> hobbies;

    /**
     * Конструктор объекта человека
     * @param name Имя
     * @param age Возраст
     * @param hobbies Коллекция хобби
     */
    public ImmutablePerson(String name, int age, ArrayList<String> hobbies) {
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
     * @return Объект человека с новым именем
     */
    public ImmutablePerson setName(String name) {
        return new ImmutablePerson(name, this.age, this.hobbies);
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
     * @return Объект человека с новым возрастом
     */
    public ImmutablePerson setAge(int age) {
        return new ImmutablePerson(this.name, age, this.hobbies);
    }

    /**
     * Получение коллекции хобби
     * @return Коллекция хобби
     */
    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    /**
     * Добавление хобби в коллекцию
     * @param hobby Новое хобби
     * @return Объект человека в хобби которого добавлено новое хобби
     */
    public ImmutablePerson addHobby(String hobby) {
        ArrayList<String> hobbies = new ArrayList<>(this.hobbies);
        hobbies.add(hobby);

        return new ImmutablePerson(this.name, this.age, hobbies);
    }

    @Override
    public String toString() {
        return name + ", " + age + " y.o.\n"
                + "Hobbies: " + hobbies + "\n";
    }
}
