package org.example.taskone;

import java.util.Random;

public final class OddNumbers implements Runnable {
    @Override
    public void run() {
        new Random()
            .ints(-1000, 1001)
            .filter(number -> number % 2 == 1)
            .limit(5)
            .forEach(System.out::println);
    }
}