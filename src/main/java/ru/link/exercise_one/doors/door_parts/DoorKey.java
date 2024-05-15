package ru.link.exercise_one.doors.door_parts;

import java.util.Arrays;

/**
 * Класс, в котором описан дверной ключ
 */
public class DoorKey {
    // Паттерн штырей на ключе
    private int[] keyPattern;

    /**
     * Конструктор ключа
     * @param pattern Паттерн штырей
     */
    public DoorKey(int[] pattern) {
        keyPattern = Arrays.copyOf(pattern, pattern.length);
    }

    /**
     * Получение паттерна ключа
     * @return Паттерн ключа
     */
    public int[] getKeyPattern() {
        return keyPattern;
    }
}
