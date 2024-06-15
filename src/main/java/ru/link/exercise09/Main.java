package ru.link.exercise09;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; ++i) {
            System.out.println(CounterSingleton.getInstance().getCount());

            if (i % 2 == 0)
                CounterSingleton.getInstance().increase();
            else
                CounterSingleton.getInstance().decrease();
        }

        System.out.println(CounterSingleton.getInstance().getCount());
    }
}
