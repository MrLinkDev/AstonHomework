package ru.link.exercise07.goods;

import java.util.HashMap;

public class Goods {
    public static final HashMap<String, Integer> LIST = new HashMap<>();

    static {
        LIST.put("Bread", 40);
        LIST.put("Milk", 50);
        LIST.put("Chocolate", 110);
        LIST.put("Cheese", 200);
        LIST.put("Sausages", 250);
        LIST.put("Juice", 120);
    }
}
