package ru.link.exercise09;

public class CounterSingleton {
    public static CounterSingleton instance = new CounterSingleton();

    private int count;

    private CounterSingleton() {
        count = 0;
    }

    public static CounterSingleton getInstance() {
        return instance;
    }

    public void increase() {
        count++;
    }

    public void decrease() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
