package ru.link.exercise01.doors.door_types;

import ru.link.exercise01.doors.Door;

/**
 * Класс описывающий стеклянную дверь без замка
 */
public class GlassDoor extends Door {
    public GlassDoor(float width, float height) {
        super(width, height);
    }

    @Override
    public String toString() {
        return "Glass " + super.toString();
    }
}
