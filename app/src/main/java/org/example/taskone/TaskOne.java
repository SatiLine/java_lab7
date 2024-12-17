package org.example.taskone;

public final class TaskOne {
    public static void start() {
        final EvenNumbers evenNumbers = new EvenNumbers();
        final Thread oddNumbers = new Thread(new OddNumbers());

        System.out.println("First task:");
        evenNumbers.start();
        oddNumbers.start();
        try {
            evenNumbers.join();
            oddNumbers.join();
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
