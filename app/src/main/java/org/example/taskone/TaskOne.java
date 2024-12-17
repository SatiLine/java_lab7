package org.example.taskone;

public final class TaskOne {
    public static void start() {
        final EvenNumbers evenNumbers = new EvenNumbers();
        final Thread oddNumbers = new Thread(new OddNumbers());

        System.out.println("First task:");
        evenNumbers.start();
        oddNumbers.start();
        try {
            evenNumbers.join(); //.join() метод заставляет текущий поток ждать завершения выполнения указанных потоков 
            oddNumbers.join(); // Это гарантирует, что программа не завершится до тех пор, пока оба потока не закончат свою работу.
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
