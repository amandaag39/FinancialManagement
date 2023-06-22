package org.example.services.mybatisimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.mapper.PaymentMapper;
import org.example.model.Payment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PaymentService implements PaymentMapper {

    private static final Logger LOGGER = LogManager.getLogger(PaymentService.class);

    public void insertPayment(Payment payment) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
                paymentMapper.insertPayment(payment);
                session.commit();
                LOGGER.info("Payment inserted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error inserting payment", e);
        }
    }

    public void updatePayment(Payment payment) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);

            // Call the mapper's updatePayment method with the provided payment object
            paymentMapper.updatePayment(payment);
            session.commit();
            LOGGER.info("Payment updated successfully: " + payment);
        } catch (IOException e) {
            LOGGER.error("Error updating payment", e);
        }
    }



    public void deletePayment(int paymentId) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
                paymentMapper.deletePayment(paymentId);
                session.commit();
                LOGGER.info("Payment with ID " + paymentId + " deleted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error deleting payment with ID: " + paymentId, e);
        }
    }

    public Payment getPaymentById(int paymentId) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
            Payment payment = paymentMapper.getPaymentById(paymentId);
            LOGGER.info("Payment by ID: {}", payment);
            return payment;

        } catch (IOException e) {
            LOGGER.error("Error selecting payment by ID: " + paymentId, e);
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
            List<Payment> payments = paymentMapper.getAllPayments();
            LOGGER.info("All Payments: {}", payments);
            return payments;
        } catch (IOException e) {
            LOGGER.error("Error getting all payments", e);
        }
        return null;
    }


    // Add more methods as per your requirements

}
