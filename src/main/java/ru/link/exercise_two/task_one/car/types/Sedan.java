package ru.link.exercise_two.task_one.car.types;

import ru.link.exercise_two.task_one.car.Car;
import ru.link.exercise_two.task_one.car.FuelType;

/**
 * Класс, в котором описан автомобиль типа седан
 */
public class Sedan extends Car {

    /**
     * Уровень роскоши
     */
    private int luxuryLevel;

    /**
     * Конструктор объекта седана
     * @param fuelType Тип топлива
     * @param numberOfDoors Количество дверей
     * @param trunkCapacity Вместимость багажного отделения
     * @param luxuryLevel Уровень роскоши
     */
    public Sedan(FuelType fuelType, int numberOfDoors, float trunkCapacity, int luxuryLevel) {
        super(fuelType, numberOfDoors, trunkCapacity);

        this.luxuryLevel = luxuryLevel;
    }

    /**
     * Получение уровня роскоши
     * @return Уровень роскоши
     */
    public String getLuxuryLevel() {
        return "Luxury level = " + luxuryLevel;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public float getTrunkCapacity() {
        return trunkCapacity ;
    }

    @Override
    public void start() {
        System.out.println("Sedan engine started");
    }

    @Override
    public void stop() {
        System.out.println("Sedan engine stopped");
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Sedan (fuel " + fuelType.getLabel() + "):\n" +
                "\tLuxury level: " + luxuryLevel + "\n" +
                "\tNumber of doors: " + numberOfDoors + "\n" +
                "\tTrunk capacity: " + trunkCapacity + "\n";
    }
}
