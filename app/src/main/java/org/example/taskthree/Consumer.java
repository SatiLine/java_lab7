package org.example.taskthree;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Consumer implements Runnable {
    private final ShoeWarehouse shoeWarehouse;
    private final int ordersToProcess;

    @Override
    public void run() {
        for (int i = 0; i < ordersToProcess; ++i) {
            shoeWarehouse.fulfillOrder();
        }
    }
}
