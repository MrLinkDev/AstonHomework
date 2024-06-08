package ru.link.exercise07.buyer;

import java.util.concurrent.atomic.AtomicInteger;

public class BuyerIdFactory {
    private static final BuyerIdFactory factory = new BuyerIdFactory();

    private final AtomicInteger currentId = new AtomicInteger(0);

    private BuyerIdFactory() {}

    public static BuyerIdFactory getInstance() {
        synchronized (BuyerIdFactory.class) {
            return factory;
        }
    }

    public int getCurrentId(){
        synchronized (BuyerIdFactory.class) {
            return currentId.getAndIncrement();
        }
    }
}
