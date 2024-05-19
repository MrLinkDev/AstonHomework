package ru.link.exercise_two.task_one.car;

/**
 * Перечисление типов топлива
 */
public enum FuelType {
    DIESEL("ДТ"),
    AI_92("АИ-92"),
    AI_95("АИ-95"),
    AI_98("АИ-98");

    /**
     * Название типа топлива
     */
    private final String label;

    FuelType(String label) {
        this.label = label;
    }

    /**
     * Получение названия топлива
     * @return название топлива в виде строки
     */
    public String getLabel() {
        return label;
    }
}
