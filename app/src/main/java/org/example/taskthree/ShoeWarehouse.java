package org.example.taskthree;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.Arrays;

public final class ShoeWarehouse {
    public final static List<ShoeType> shoeTypes = Arrays.asList(ShoeType.values());
    public final static int MAX_ORDERS = 5;
    private final BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>(MAX_ORDERS);
    private final ExecutorService executorService;

    public ShoeWarehouse(final int consumersNumber, final int ordersPerConsumer) {
        executorService = Executors.newFixedThreadPool(consumersNumber);
        for(int i = 0; i < consumersNumber; ++i) {
            executorService.submit(new Consumer(this, ordersPerConsumer));
        }
        executorService.shutdown();
    }

    public void receiveOrder(final Order order) {
        try {
            orders.put(order);
            System.out.println("New order: " + order);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public Order fulfillOrder() {
        try {
            final Order order = orders.take();
            System.out.println("Order processed: " + order);
            return order;
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
