package com.examples.java.mod.order;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void createOrder(Order order) {
        orders.put(order.getId(), order);
        System.out.println("Order Created - " + order);
    }

    @Override
    public void updateOrder(Order order, int id) {
        orders.put(order.getId(), order);
        System.out.println("Order Updated - " + order);
    }

    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }

    @Override
    public void deleteOrder(int id) {
        orders.remove(id);
    }
}
