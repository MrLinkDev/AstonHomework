package ru.link.exercise_one.doors.interfaces;

import ru.link.exercise_one.doors.door_parts.DoorKey;

/**
 * Интерфейс, описывающий дверь, которую можно открыть
 */
public interface Openable {
    /**
     * Открытие двери
     */
    void open();

    /**
     * Открытие двери с ключом
     * @param key
     */
    void open(DoorKey key);

    /**
     * Открытие двери с отмычкой
     * @param usePicklock
     */
    void open(boolean usePicklock);
}
