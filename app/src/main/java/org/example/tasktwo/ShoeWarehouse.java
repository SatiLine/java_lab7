package org.example.tasktwo;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Arrays;

public final class ShoeWarehouse {
    public final static List<ShoeType> shoeTypes = Arrays.asList(ShoeType.values());
    public final static int MAX_ORDERS = 5;
    private final BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>(MAX_ORDERS);

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
