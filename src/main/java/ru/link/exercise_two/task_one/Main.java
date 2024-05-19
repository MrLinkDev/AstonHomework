package ru.link.exercise_two.task_one;

import ru.link.exercise_two.task_one.car.Car;
import ru.link.exercise_two.task_one.car.FuelType;
import ru.link.exercise_two.task_one.car.types.Sedan;
import ru.link.exercise_two.task_one.car.types.Truck;

public class Main {
    public static void main(String[] args) {
        // Создание объектов седанов
        Car cheapSedan = new Sedan(FuelType.AI_92, 4, 80, 1);
        Car expensiveSedan = new Sedan(FuelType.AI_98, 4, 50, 5);

        // Создание объекта грузовика
        Car truck = new Truck(FuelType.DIESEL, 2, 0, 1000);

        // Вывод информации о седанах
        System.out.println(cheapSedan);
        System.out.println(expensiveSedan);

        // Вывод информации о грузовике
        System.out.println(truck);

        // Запускаем двигатель автомобилей и получаем название топлива
        Car[] cars = new Car[]{cheapSedan, expensiveSedan, truck};
        for (Car car : cars) {
            car.start();
            System.out.println("This car need " + car.getFuelType().getLabel() + " fuel\n");
        }

        // Останавливаем двигатель автомобилей
        for (Car car : cars) {
            car.stop();
        }
    }
}
