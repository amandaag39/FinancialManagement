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
//        AccountService accountService = new AccountService();
//
//        // Get an account by ID
//        Account account = accountService.getAccountById(1);
//        LOGGER.info("Account by ID: " + account);
//
//        // Get all accounts
//        List<Account> accounts = accountService.getAllAccounts();
//        LOGGER.info("All Accounts: " + accounts);
//
//        // Delete an account
//        int accountIdToDelete = 10;
//        accountService.deleteAccountById(accountIdToDelete);
//        LOGGER.info("Account with ID " + accountIdToDelete + " deleted successfully!");
//
//        // Insert a new account
//        Account newAccount = new Account(
//                20,
//                11,
//                "Savings",
//                BigDecimal.valueOf(1000.0),
//                LocalDateTime.now()
//        );
//        accountService.insertAccount(newAccount);
//        LOGGER.info("Account inserted successfully!");
//
//        // Update an account
//        Account existingAccount = accountService.getAccountById(2);
//        existingAccount.setAccountType("Checking");
//        existingAccount.setBalance(BigDecimal.valueOf(2000.0));
//        accountService.updateAccount(existingAccount);
//        LOGGER.info("Account updated successfully: " + existingAccount);
//end region


//region PaymentService
        // Test the PaymentService methods
        PaymentService paymentService = new PaymentService();
        List<Payment> payments = paymentService.getAllPayments();

    }
}
