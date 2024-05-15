package ru.link.exercise_one;

import ru.link.exercise_one.doors.Door;
import ru.link.exercise_one.doors.DoorFactory;
import ru.link.exercise_one.doors.DoorFactoryPackage;
import ru.link.exercise_one.doors.DoorMaterial;
import ru.link.exercise_one.doors.door_parts.DoorKey;

public class Main {
    // Создаём абстрактную дверь
    static {
        Door abstractDoor = new Door(100000, 200000);
        System.out.println("Abstract door created in static initializer block: " + abstractDoor);
    }

    public static void main(String[] args) {
        // Получаем набор упаковок от дверной фабрики
        DoorFactoryPackage firstPackage = DoorFactory.orderPackage(DoorMaterial.WOOD, 500, 2000, false);
        DoorFactoryPackage secondPackage = DoorFactory.orderPackage(DoorMaterial.WOOD, 500, 2000, true);
        DoorFactoryPackage thirdPackage = DoorFactory.orderPackage(DoorMaterial.GLASS, 500, 2000, true);
        DoorFactoryPackage fourthPackage = DoorFactory.orderPackage(DoorMaterial.NONE, 500, 2000, true);
        
        Door firstDoor = firstPackage.getDoor();
        DoorKey firstDoorKey = firstPackage.getDoorKey();
        
        Door secondDoor = secondPackage.getDoor();
        DoorKey secondDoorKey = secondPackage.getDoorKey();
        
        Door thirdDoor = thirdPackage.getDoor();
        DoorKey thirdDoorKey = thirdPackage.getDoorKey();
        
        Door fourthDoor = fourthPackage.getDoor();
        DoorKey fourthDoorKey = fourthPackage.getDoorKey();

        // Проверяем размеры дверей
        System.out.println("\n\n===== DOOR SIZE TEST =====");

        System.out.printf("First door size: %fmm X %fmm\n", firstDoor.getWidth(), firstDoor.getHeight());

        firstDoor.setWidth(firstDoor.getWidth() / 2);
        firstDoor.setHeight(firstDoor.getHeight() / 2);

        System.out.printf("First door size: %fmm X %fmm\n", firstDoor.getWidth(), firstDoor.getHeight());

        firstDoor.setWidth(firstDoor.getWidth() * 2);
        firstDoor.setHeight(firstDoor.getHeight() * 2);

        System.out.printf("First door size: %fmm X %fmm\n", firstDoor.getWidth(), firstDoor.getHeight());

        // Проверяем описание дверей
        System.out.println("\n\n===== DOOR TO STRING TEST =====");

        System.out.println(firstDoor);
        System.out.println(secondDoor);
        System.out.println(thirdDoor);
        System.out.println(fourthDoor);

        // Проверяем надёжность замков дверей
        System.out.println("\n\n===== DOOR OPEN WITHOUT KEY TEST =====");

        Door[] doors = new Door[] {firstDoor, secondDoor, thirdDoor, fourthDoor};
        DoorKey[] doorKeys = new DoorKey[] {firstDoorKey, secondDoorKey, thirdDoorKey, fourthDoorKey};

        for (int i = 0; i < 4; ++i) {
            doors[i].open();
        }

        // Проверяем ключи от дверей
        System.out.println("\n\n===== DOOR OPEN WITH OWN KEY TEST =====");

        for (int i = 0; i < 4; ++i) {
            doors[i].open(doorKeys[i]);
        }

        // Проверяем уникальность ключей от дверей
        System.out.println("\n\n===== DOOR OPEN WITH KEY FROM OTHER DOOR TEST =====");

        for (int i = 0; i < 4; ++i) {
            doors[i].open(doorKeys[4 - i - 1]);
        }

        // Второй раз проверяем надёжность замков дверей
        System.out.println("\n\n===== DOOR OPEN WITH PICKLOCK TEST =====");

        for (int i = 0; i < 4; ++i) {
            doors[i].open(true);
        }
    }
}
