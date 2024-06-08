package ru.link.exercise07;

import ru.link.exercise07.buyer.Buyer;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MIN_BPS = 0;                       // Min buyers per second
    private static final int MAX_BPS = 2;                       // Max buyers per second

    private static final int WORK_TIME_S = 120;
    private static final int SLEEP_TIME_BETWEEN_BUYERS_WAVE_MS = 1000;

    private static final int MAX_THREADS = MAX_BPS * WORK_TIME_S;

    private static final ExecutorService service = Executors.newFixedThreadPool(MAX_THREADS);
    private static final Random random = new Random();

    public static void main(String[] args) {
        Instant startTime = Instant.now();

        while (Duration.between(startTime, Instant.now()).getSeconds() < WORK_TIME_S) {
            int buyersCount = random.nextInt(MIN_BPS, MAX_BPS + 1);
            for (int i = 0; i < buyersCount; ++i) {
                service.submit(new Buyer());
            }

            try {
                Thread.sleep(SLEEP_TIME_BETWEEN_BUYERS_WAVE_MS);
            } catch (InterruptedException e) {
                return;
            }
        }

        service.shutdown();
    }
}
