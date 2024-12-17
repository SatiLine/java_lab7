package org.example.taskone;

import java.util.Random;

public final class EvenNumbers extends java.lang.Thread {
    @Override
    public void run() {
        new Random()
            .ints(-1000, 1001)
            .filter(number -> number % 2 == 0)
            .limit(5)
            .forEach(System.out::println);
    }
}

