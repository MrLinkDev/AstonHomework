package ru.link.exercise01.doors;

import ru.link.exercise01.doors.door_parts.DoorKey;
import ru.link.exercise01.doors.door_parts.DoorLock;
import ru.link.exercise01.doors.door_types.GlassDoor;
import ru.link.exercise01.doors.door_types.WoodenDoorWithLock;
import ru.link.exercise01.doors.door_types.WoodenDoorWithoutLock;

import java.util.Random;

/**
 * Класс, в котором описана фабрика по созданию дверей
 */
public class DoorFactory {
    // Минимальная высота штыря в замке
    public static final int PIN_HEIGHT_MIN_VALUE = 0;
    // Максимальная высота штыря в замке
    public static final int PIN_HEIGHT_MAX_VALUE = 10;

    // Минимальная прочность замка
    public static final int LOCK_MIN_STRENGTH = 0;
    // Максимальная прочность замка
    public static final int LOCK_MAX_STRENGTH = 5;

    // Количество штырей в замке
    public static final byte PIN_COUNT = 5;

    /**
     * Создание двери
     * @param doorMaterial Материал двери
     * @param doorWidth Ширина двери
     * @param doorHeight Высота двери
     * @param needLock Флаг, показывающий, что требуется замок
     * @return Экземпляр упаковки, в которой содержится дверь и, если требуется, ключ
     */
    public static DoorFactoryPackage orderPackage(DoorMaterial doorMaterial, float doorWidth, float doorHeight, boolean needLock) {
        Door door = null;
        DoorLock doorLock = null;
        DoorKey doorKey = null;

        if (needLock) {
            int[] lockPattern = new int[PIN_COUNT];
            int lockStrength = 0;

            int[] keyPattern = new int[PIN_COUNT];

            Random random = new Random();

            for (int i = 0; i < PIN_COUNT; ++i) {
                lockPattern[i] = random.nextInt(PIN_HEIGHT_MIN_VALUE, PIN_HEIGHT_MAX_VALUE);
                keyPattern[i] = PIN_HEIGHT_MAX_VALUE - lockPattern[i];
            }
            lockStrength = random.nextInt(LOCK_MIN_STRENGTH, LOCK_MAX_STRENGTH);

            doorLock = new DoorLock(lockPattern, lockStrength);
            doorKey = new DoorKey(keyPattern);
        }

        switch (doorMaterial) {
            case GLASS -> {
                return new DoorFactoryPackage(new GlassDoor(doorWidth, doorHeight));
            }
            case WOOD -> {
                if (needLock) {
                    return new DoorFactoryPackage(new WoodenDoorWithLock(doorWidth, doorHeight, doorLock), doorKey);
                } else {
                    return new DoorFactoryPackage(new WoodenDoorWithoutLock(doorWidth, doorHeight));
                }
            }
            default -> {
                if (needLock) {
                    return new DoorFactoryPackage(new Door(doorWidth, doorHeight, doorLock), doorKey);
                } else {
                    return new DoorFactoryPackage(new Door(doorWidth, doorHeight));
                }
            }
        }
    }
}
