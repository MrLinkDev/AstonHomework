package ru.link.exercise_two.task_one.car;

/**
 * Интерфейс, описывающий транспортное средство
 */
public interface Vehicle {

    /**
     * Запуск транспортного средства
     */
    void start();

    /**
     * Остановка транспортного средства
     */
    void stop();

    /**
     * Получение типа топлива транспортного средства
     * @return тип топлива
     */
    FuelType getFuelType();
}
