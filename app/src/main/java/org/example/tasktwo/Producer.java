package org.example.tasktwo;

import java.util.Random;
import java.util.function.Supplier; //нтерфейс, указывающий, что данная реализация является поставщиком какого-то результа
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Producer extends Thread{
    private final ShoeWarehouse shoeWarehouse;
    private final int ordersNumber; 

    @Override
    public void run() {
        Stream.generate(new Supplier<Order>() { //объект, реализующий интерфейс Supplier<Order>, который будет генерировать новые заказы.
            private int id = 0;
            private final Random random = new Random();

            @Override
            public Order get() {
                return new Order(
                    id++,
                    ShoeWarehouse.shoeTypes.get(random.nextInt(ShoeWarehouse.shoeTypes.size())),
                    random.nextInt(1, 10));
            }
        })
        .limit(ordersNumber)
        .forEach(order -> shoeWarehouse.receiveOrder(order));
    }
}
