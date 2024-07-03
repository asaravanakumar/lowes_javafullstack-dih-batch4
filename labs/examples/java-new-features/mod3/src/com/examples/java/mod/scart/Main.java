package com.examples.java.mod.scart;

import com.examples.java.mod.order.Order;
import com.examples.java.mod.order.OrderService;
import com.examples.java.mod.order.OrderServiceImpl;
import com.examples.java.mod.product.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("Module #3 - Hello world!");
        Order order = new Order(100, "Smart TV", 2, 50000.0);
        System.out.println(order);

        Product product = new Product(200, "Smart Phone", "Samsung Galaxy M40", 20000.0);
        System.out.println(product);

        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(order);
        System.out.println(orderService.getOrder(100));
    }
}