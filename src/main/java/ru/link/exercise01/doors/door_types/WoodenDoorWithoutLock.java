package ru.link.exercise01.doors.door_types;

import ru.link.exercise01.doors.Door;

/**
 * Класс описывающий деревянную дверь без замка
 */
public class WoodenDoorWithoutLock extends Door {
    public WoodenDoorWithoutLock(float width, float height) {
        super(width, height);
    }

    @Override
    public String toString() {
        return "Wooden " + super.toString() + " (Without lock)";
    }
}
