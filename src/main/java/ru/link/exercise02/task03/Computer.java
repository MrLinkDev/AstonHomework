package ru.link.exercise02.task03;

/**
 * Класс, описывающий компьютер
 */
public class Computer {

    /**
     * Статический класс, описывающий процессор
     */
    static class Processor {
        /**
         * Модель процессора
         */
        String model;

        /**
         * Конструктор объекта процессора
         * @param model Модель процессора
         */
        public Processor(String model) {
            this.model = model;
        }

        /**
         * Получение модели процессора
         * @return Модель процессора в виде строки
         */
        String getDetails() {
            return model;
        }
    }

    /**
     * Класс, описывающий оперативную память компьютера
     */
    class Ram {
        /**
         * Размер оперативной памяти
         */
        float size;

        /**
         * Конструктор объекта оперативной памяти
         * @param size Размер оперативной памяти
         */
        public Ram(float size) {
            this.size = size;
        }

        /**
         * Получение размера оперативной памяти
         * @return Размер оперативной памяти
         */
        public float getDetails() {
            return size;
        }
    }

    // Создание экземпляра объекта оперативной памяти
    public Computer.Ram ram = new Computer.Ram(63.7f);

    public static void main(String[] args) {
        // Создание экземпляра процессора и получение информации о модели
        Computer.Processor processor = new Processor("Intel core i7-13700K");
        System.out.println("CPU: " + processor.getDetails());

        // Создание экземпляра объекта компьютера для доступа к RAM
        Computer computer = new Computer();
        System.out.println("RAM: " + computer.ram.getDetails() + " GB");
    }
}
