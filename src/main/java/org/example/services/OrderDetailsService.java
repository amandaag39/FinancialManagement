package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.OrderDetails;

import java.util.List;

public class OrderDetailsService {
    private GenericDAOImpl<OrderDetails> orderDetailsDAO;

    public OrderDetailsService(GenericDAOImpl<OrderDetails> orderDetailsDAO) {
        this.orderDetailsDAO = orderDetailsDAO;
    }

    public void createOrderDetails(OrderDetails orderDetails) {
        orderDetailsDAO.create(orderDetails);
    }

    public OrderDetails getOrderDetailsById(int id) {
        return orderDetailsDAO.getById(id);
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsDAO.getAll();
    }

    public void updateOrderDetails(OrderDetails orderDetails) {
        orderDetailsDAO.update(orderDetails);
    }

    public void deleteOrderDetails(OrderDetails orderDetails) {
        orderDetailsDAO.delete(orderDetails);
    }
}
