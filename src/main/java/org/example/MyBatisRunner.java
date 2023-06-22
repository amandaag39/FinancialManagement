package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Account;
import org.example.model.Payment;
import org.example.model.User;
import org.example.services.mybatisimpl.AccountService;
import org.example.services.mybatisimpl.PaymentService;
import org.example.services.mybatisimpl.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MyBatisRunner {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);
    public static void main(String[] args) {

//region UserService
//        UserService userService = new UserService();
//
//        // Get a user by ID
//        User user = userService.selectUserById(1);
//
//        // Get all users
//        List<User> users = userService.getAllUsers();
//
//        // Delete a user
//        userService.deleteUserById(35);
//
//        // Insert a new user
//        User newUser = new User(
//                "jean.kirstein",
//                "j.kirstein@example.com",
//                "cozyinterior",
//                "Jean",
//                "Kirstein",
//                LocalDate.of(2007, 1, 15),
//                LocalDateTime.of(2023, 6, 5, 12, 31, 32),
//                LocalDateTime.of(2023, 6, 5, 12, 31, 32)
//        );
//        userService.insertUser(newUser);
//
//        // Update a user
//        User existingUser = userService.selectUserById(1);
//        existingUser.setUsername("doe.john");
//        existingUser.setEmail("john.doe@example.com");
//        existingUser.setPassword("newpassword");
//        existingUser.setFirstName("Johnny");
//        userService.updateUser(existingUser);
//end region


//region AccountService
        // Test the getAccountById method
        AccountService accountService = new AccountService();
        Account account = accountService.getAccountById(1);

        // Test the getAllAccounts method
//        List<Account> accounts = accountService.getAllAccounts();

        // Test the deleteAccountById method
//        accountService.deleteAccountById(5);

        // Test the insertAccount method
//        Account newAccount = new Account(6,6, "Business", BigDecimal.valueOf(20.00), LocalDateTime.of(2023, 6, 5, 12, 31, 32));
//        accountService.insertAccount(newAccount);

        // Test the updateAccount method
//        Account existingAccount = accountService.getAccountById(1);
//        existingAccount.setBalance(BigDecimal.valueOf(10.10));
//        accountService.updateAccount(existingAccount);


//end region


//region PaymentService
//        // Test the getAllPayments method
//        PaymentService paymentService = new PaymentService();
//        List<Payment> payments = paymentService.getAllPayments();
//
//        // Test the getPaymentById method
//        Payment payment = paymentService.getPaymentById(8);
//
//        // Test the updatePayment method
//        Payment existingPayment = paymentService.getPaymentById(1);
//        existingPayment.setAmount(BigDecimal.valueOf(200.10));
//        paymentService.updatePayment(existingPayment);
//
//        // Test the deletePayment method
//        paymentService.deletePayment(8);
//
//        // Test the insertPayment method
//        Payment newPayment = new Payment(8,4,BigDecimal.valueOf(1000.0),1, LocalDateTime.of(2023, 6, 5, 12, 31, 32));
//        paymentService.insertPayment(newPayment);

    }
}
