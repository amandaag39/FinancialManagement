package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Payment;

import java.util.List;

public class PaymentService {
    private GenericDAOImpl<Payment> paymentDAO;

    public PaymentService(GenericDAOImpl<Payment> paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public void createPayment(Payment payment) {
        paymentDAO.create(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentDAO.getById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAll();
    }

    public void updatePayment(Payment payment) {
        paymentDAO.update(payment);
    }

    public void deletePayment(Payment payment) {
        paymentDAO.delete(payment);
    }
}
