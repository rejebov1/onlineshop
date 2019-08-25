package org.myproject.service;

import org.myproject.repository.entity.Order;

import java.util.List;

public interface OrderService {

    Long addNewOrder(Order order);

    void add (Order order);

    void deleteOrder(Long orderId);

    Order getById(Long id);

    List<Order> getAll();

    Order update(Order order);

//    boolean delete(Long id);

}
