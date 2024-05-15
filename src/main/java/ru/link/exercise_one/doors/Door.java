package ru.link.exercise_one.doors;

import ru.link.exercise_one.doors.door_parts.DoorKey;
import ru.link.exercise_one.doors.interfaces.Openable;
import ru.link.exercise_one.doors.door_parts.DoorLock;

/**
 * Класс, описывающий дверь
 */
public class Door implements Openable {
    // Ширина двери
    private float width;
    // Высота двери
    private float height;

    // Дверной замок
    DoorLock doorLock;

    /**
     * Конструктор для создания двери без замка
     * @param width Ширина двери
     * @param height Высота двери
     */
    public Door(float width, float height) {
        this.width = width;
        this.height = height;

        this.doorLock = null;
    }

    /**
     * Конструктор для создания двери без замка
     * @param width Ширина двери
     * @param height Высота двери
     * @param doorLock Экземпляр дверного замка
     */
    public Door(float width, float height, DoorLock doorLock) {
        this.width = width;
        this.height = height;

        this.doorLock = doorLock;
    }

    /**
     * Получение ширины двери
     * @return Ширина двери
     */
    public float getWidth() {
        return width;
    }

    /**
     * Установка ширины двери. Новая ширина двери не может быть больше текущей.
     * @param width Новая ширина двери
     */
    public void setWidth(float width) {
        if (width > this.width) {
            System.out.println("You can't increase width of door");
        } else {
            this.width = width;
        }
    }

    /**
     * Получение высоты двери
     * @return Высота двери
     */
    public float getHeight() {
        return height;
    }

    /**
     * Установка высоты двери. Новая высота двери не может быть больше текущей.
     * @param height Новая высота двери
     */
    public void setHeight(float height) {
        if (height > this.height) {
            System.out.println("You can't increase height of door");
        } else {
            this.height = height;
        }
    }

    @Override
    public void open() {
        if (doorLock == null) {
            System.out.println("Door is open");
        } else {
            System.out.println("You should use your key!");
        }
    }

    @Override
    public void open(DoorKey key) {
        if (doorLock == null) {
            System.out.println("This door doesn't need a key");
        } else {
            if (key == null) {
                System.out.println("There is the key?");
            } else {
                if (doorLock.tryUnlock(key)) {
                    System.out.println("Door is open");
                } else {
                    System.out.println("You should use your key!");

                    if (doorLock.tryUnlock()) {
                        System.out.println("This door lock is useless");
                    } else {
                        System.out.println("Still need a key");
                    }
                }
            }
        }
    }

    @Override
    public void open(boolean usePicklock) {
        if (doorLock == null) {
            System.out.println("This door doesn't need a key");
        } else {
            if (usePicklock && doorLock.tryUnlock(usePicklock)) {
                System.out.println("Door is opened with picklock!");
            } else {
                System.out.println("You should use your key!");
            }
        }
    }

    @Override
    public String toString() {
        return "Door: " + width + "mm X " + height + "mm" ;
    }
}
