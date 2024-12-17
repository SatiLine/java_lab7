package org.example.tasktwo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskTwo {
    public static void start() {
        final int ORDERS_TO_PROCESS = 50;
        final int ORDERS_PER_CONSUMER = 5;
        final ShoeWarehouse warehouse = new ShoeWarehouse();
        final Producer producer = new Producer(warehouse, ORDERS_TO_PROCESS);
        final List<Consumer> consumers = 
            Stream.generate(() -> new Consumer(warehouse))
                .limit(ORDERS_TO_PROCESS / ORDERS_PER_CONSUMER)
                .collect(Collectors.toList());
        System.out.println("Second task:");
        producer.start();
        for(Consumer consumer : consumers) {
            consumer.start();
        }
        try {
            producer.join();
            for(Consumer consumer : consumers) {
                consumer.join();
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
