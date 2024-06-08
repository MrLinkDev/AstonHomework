package ru.link.exercise07.buyer;

import ru.link.exercise07.goods.Goods;

import java.util.Arrays;
import java.util.Random;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private final int MIN_SLEEP_TIME_MS = 500;
    private final int MAX_SLEEP_TIME_MS = 2000;

    private final int MIN_GOODS = 1;
    private final int MAX_GOODS = 4;

    private final Random random;

    private final int id;

    private final long takeBasketSleepTime;
    private final long chooseGoodsSleepTime;
    private final long putGoodsSleepTime;

    private String[] basket;
    private int goodsCount;

    private final Object printMutex = new Object();

    public Buyer() {
        this.id = BuyerIdFactory.getInstance().getCurrentId();

        this.random = new Random();

        this.takeBasketSleepTime = random.nextLong(MIN_SLEEP_TIME_MS, MAX_SLEEP_TIME_MS + 1);
        this.chooseGoodsSleepTime = random.nextLong(MIN_SLEEP_TIME_MS, MAX_SLEEP_TIME_MS + 1);
        this.putGoodsSleepTime = random.nextLong(MIN_SLEEP_TIME_MS, MAX_SLEEP_TIME_MS + 1);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) enter to market\n", id);
        }
    }

    @Override
    public void takeBasket() {
        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) taking basket (for %04d ms)\n", id, chooseGoodsSleepTime);
        }

        goodsCount = random.nextInt(MIN_GOODS, MAX_GOODS + 1);
        basket = new String[goodsCount];

        try {
            sleep(takeBasketSleepTime);
        } catch (InterruptedException ignored) {
        }


        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) took basket\n", id);
        }
    }

    @Override
    public void chooseGoods() {
        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) choosing goods (for %04d ms)\n", id, chooseGoodsSleepTime);
        }

        try {
            sleep(chooseGoodsSleepTime);
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 0; i < goodsCount; ++i) {
            basket[i] = (String) Goods.LIST.keySet().toArray()[random.nextInt(Goods.LIST.size())];
        }

        try {
            sleep(putGoodsSleepTime);
        } catch (InterruptedException ignored) {
        }

        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) chose this goods: ", id);
            System.out.print(Arrays.toString(basket));
            System.out.println(". Total: " + Arrays.stream(basket).mapToInt(Goods.LIST::get).reduce(Integer::sum).getAsInt() + "$");
        }
    }

    @Override
    public void goOut() {
        synchronized (printMutex) {
            System.out.printf("Buyer (%03d) going out\n", id);
        }
    }
}
