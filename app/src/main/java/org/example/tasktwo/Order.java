package org.example.tasktwo;

public final record Order(int id, ShoeType type, int quantity) {
    public Order {
        if(id < 0) {
            throw new IllegalArgumentException("Order ID should be a non-negative number.");
        }
        if(quantity <= 0) {
            throw new IllegalArgumentException("Order quantity should be a positive number.");
        }
    }
}
