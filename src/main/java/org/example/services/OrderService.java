package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Order;

import java.util.List;

public class OrderService {
    private GenericDAOImpl<Order> orderDAO;

    public OrderService(GenericDAOImpl<Order> orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(Order order) {
        orderDAO.create(order);
    }

    public Order getOrderById(int id) {
        return orderDAO.getById(id);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAll();
    }

    public void updateOrder(Order order) {
        orderDAO.update(order);
    }

    public void deleteOrder(Order order) {
        orderDAO.delete(order);
    }
}
