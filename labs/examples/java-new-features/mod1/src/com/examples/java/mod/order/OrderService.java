package com.examples.java.mod.order;

public interface OrderService {
    public void createOrder(Order order);

    public void updateOrder(Order order, int id);

    public Order getOrder(int id);

    public void deleteOrder(int id);
}
