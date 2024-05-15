package ru.link.exercise_one.doors;

import ru.link.exercise_one.doors.door_parts.DoorKey;

/**
 * Класс, который описывает упаковку
 */
public class DoorFactoryPackage {
    // Экземпляр двери, которая хранится в упаковке
    private Door door;
    // экземпляр ключа от двери, который хранится в упаковке
    private DoorKey doorKey;

    // Перед упаковкой двери готовим картон для упаковки
    {
        System.out.println("Cardboard is ready");
    }

    /**
     * Конструктор упаковки для двери без замка
     * @param door Экземпляр двери
     */
    public DoorFactoryPackage(Door door) {
        System.out.println("Packing...");

        this.door = door;
        this.doorKey = null;
    }

    /**
     * Конструктор упаковки для двери с замком
     * @param door Экземпляр двери
     * @param doorKey Экземпляр ключа от двери
     */
    public DoorFactoryPackage(Door door, DoorKey doorKey) {
        System.out.println("Packing...");

        this.door = door;
        this.doorKey = doorKey;
    }

    /**
     * Достаём дверь из упаковки
     * @return Экземпляр двери
     */
    public Door getDoor() {
        return door;
    }

    /**
     * Достаём ключ от двери из упаковки
     * @return Экземпляр ключа от двери
     */
    public DoorKey getDoorKey() {
        return doorKey;
    }
}
