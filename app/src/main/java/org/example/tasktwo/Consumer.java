package org.example.tasktwo;

import lombok.RequiredArgsConstructor; //Эта аннотация автоматически генерирует конструктор для всех полей класса, 
                                       //которые объявлены как final

@RequiredArgsConstructor
public final class Consumer extends Thread {
    public static final int MAX_ORDERS_PROCESSED = 5;
    private final ShoeWarehouse shoeWarehouse;

    @Override
    public void run() {
        for (int i = 0; i < MAX_ORDERS_PROCESSED; ++i) {
            shoeWarehouse.fulfillOrder();
        }
    }
}
