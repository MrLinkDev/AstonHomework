package ru.link.exercise01.doors.door_parts;

import ru.link.exercise01.doors.DoorFactory;

import java.util.Random;

/**
 * Класс, в котором описан дверной замок
 */
public class DoorLock {
    private final Random random = new Random();

    // Высота штырей в замке
    private final int[] lockPattern;
    // Прочность замка
    private final int lockStrength;

    /**
     * Конструктор класса
     * @param lockPattern Паттерн штырей в замке
     * @param lockStrength Прочность замка
     */
    public DoorLock(int[] lockPattern, int lockStrength) {
        this.lockPattern = lockPattern;
        this.lockStrength = lockStrength;
    }

    /**
     * Открытие замка без ключа
     * @return Если прочность замка нулевая - возвращает true
     */
    public boolean tryUnlock() {
        return lockStrength == 0;
    }

    /**
     * Открытие замка с помощью ключа
     * @param key Ключ для двери
     * @return Если ключ подходит, возвращает true
     */
    public boolean tryUnlock(DoorKey key) {
        int[] keyPattern = key.getKeyPattern();

        if (keyPattern.length != lockPattern.length) {
            return false;
        }

        for (int i = 0; i < keyPattern.length; ++i) {
            if (DoorFactory.PIN_HEIGHT_MAX_VALUE - keyPattern[i] != lockPattern[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Открытие замка с помощью отмычки
     * @param usePicklock Флаг, показывающий, что используется отмычка
     * @return Если величина удачи больше, чем прочность замка, возвращает true
     */
    public boolean tryUnlock(boolean usePicklock) {
        if (!usePicklock) {
            return tryUnlock();
        }

        int luckyStrength = random.nextInt(DoorFactory.LOCK_MIN_STRENGTH, DoorFactory.LOCK_MAX_STRENGTH);

        return luckyStrength > lockStrength;
    }

}
