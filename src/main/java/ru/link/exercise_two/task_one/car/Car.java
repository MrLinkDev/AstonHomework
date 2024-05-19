package ru.link.exercise_two.task_one.car;

/**
 * Абстрактный класс, в котором описан автомобиль
 */
public abstract class Car implements Vehicle {

    /**
     * Тип топлива
     */
    protected FuelType fuelType;

    /**
     * Количество дверей
     */
    protected int numberOfDoors;

    /**
     * Объём багажного отделения
     */
    protected float trunkCapacity;

    /**
     * Конструктор объекта автомобиля
     * @param fuelType Тип топлива
     * @param numberOfDoors Количество дверей
     * @param trunkCapacity Объём багажного отделения
     */
    public Car(FuelType fuelType, int numberOfDoors, float trunkCapacity) {
        this.fuelType = fuelType;

        this.numberOfDoors = numberOfDoors;
        this.trunkCapacity = trunkCapacity;
    }

    /**
     * Получение количества дверей в автомобиле
     * @return Количество дверей
     */
    public abstract int getNumberOfDoors();

    /**
     * Получение объёма багажного отделения в автомобиле
     * @return Объём багажного отделения
     */
    public abstract float getTrunkCapacity();
}
