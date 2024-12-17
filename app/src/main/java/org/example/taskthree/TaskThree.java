package org.example.taskthree;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThree {
    public static void start() {
        final int ORDERS_TO_PROCESS = 50;
        final int ORDERS_PER_CONSUMER = 5;
        final ShoeWarehouse warehouse = new ShoeWarehouse(ORDERS_TO_PROCESS / ORDERS_PER_CONSUMER, ORDERS_PER_CONSUMER);
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Producer(warehouse, ORDERS_TO_PROCESS));
        System.out.println("Third task:");
        executorService.shutdown();
    }
}
