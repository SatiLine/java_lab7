package org.example.tasktwo;

import java.util.List;
import java.util.concurrent.BlockingQueue; //интерфейс для очередей, поддерживающих блокировку при добавлении и удалении элементов.
import java.util.concurrent.LinkedBlockingQueue; //реализация BlockingQueue, которая использует связный список для хранения элементов.
import java.util.Arrays; //для работы с массивами, в данном случае для преобразования массива типов обуви в список.

public final class ShoeWarehouse {
    public final static List<ShoeType> shoeTypes = Arrays.asList(ShoeType.values());
    public final static int MAX_ORDERS = 5;
    private final BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>(MAX_ORDERS); //очередь для управления заказами

    public void receiveOrder(final Order order) {
        try {
            orders.put(order); //Метод put() добавляет заказ в очередь
            System.out.println("New order: " + order);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public Order fulfillOrder() {
        try {
            final Order order = orders.take(); //Метод take() удаляет и возвращает следующий заказ из очереди
            System.out.println("Order processed: " + order);
            return order;
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
