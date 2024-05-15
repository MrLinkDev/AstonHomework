package ru.link.exercise_one.doors.door_types;

import ru.link.exercise_one.doors.Door;
import ru.link.exercise_one.doors.door_parts.DoorLock;

/**
 * Класс описывающий деревянную дверь с замком
 */
public class WoodenDoorWithLock extends Door {
    public WoodenDoorWithLock(float width, float height, DoorLock doorLock) {
        super(width, height, doorLock);
    }

    @Override
    public String toString() {
        return "Wooden " + super.toString() + " (With lock)";
    }
}
