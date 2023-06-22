package org.example.mapper;

import org.example.model.Payment;

import java.util.List;

public interface PaymentMapper {

    void insertPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(int paymentId);

    Payment getPaymentById(int paymentId);

    List<Payment> getAllPayments();

}
