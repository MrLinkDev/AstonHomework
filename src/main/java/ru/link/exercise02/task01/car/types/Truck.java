package ru.link.exercise02.task01.car.types;

import ru.link.exercise02.task01.car.Car;
import ru.link.exercise02.task01.car.FuelType;

/**
 * Класс, в котором описан автомобиль типа грузовик
 */
public class Truck extends Car {
    /**
     * Максимальная грузоподъёмность
     */
    private int maxLoadCapacity;

    /**
     * Конструктор объекта грузовика
     * @param fuelType Тип топлива
     * @param numberOfDoors Количество дверей
     * @param trunkCapacity Вместимость багажного отделения
     * @param maxLoadCapacity Максимальная грузоподъёмность
     */
    public Truck(FuelType fuelType, int numberOfDoors, float trunkCapacity, int maxLoadCapacity) {
        super(fuelType, numberOfDoors, trunkCapacity);

        this.maxLoadCapacity = maxLoadCapacity;
    }

    /**
     * Получение максимальной грузоподъёмности
     * @return Максимальная грузоподъёмность
     */
    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public float getTrunkCapacity() {
        return trunkCapacity;
    }

    @Override
    public void start() {
        System.out.println("Truck engine started");
    }

    @Override
    public void stop() {
        System.out.println("Truck engine stopped");
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Truck (fuel " + fuelType.getLabel() + "):\n" +
                "\tMax load capacity: " + maxLoadCapacity + "\n" +
                "\tNumber of doors: " + numberOfDoors + "\n" +
                "\tTrunk capacity: " + trunkCapacity + "\n";
    }
}
