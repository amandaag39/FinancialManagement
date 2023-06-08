package org.example;

import org.example.dao.GenericDAOImpl;
import org.example.model.User;
import org.example.parsers.DOMParser;
import org.example.parsers.XMLParser;
import org.example.services.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        // Homework 14 -
//        //Initial test of the DB connection after adding Maven dependency
//        try {
//            Connection connection = DatabaseConnection.getConnection();
//            Statement statement = connection.createStatement();
//            String sql = "SELECT * FROM user";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            // Process the retrieved data
//            while (resultSet.next()) {
//                // Access individual columns using resultSet.getXXX() methods
//                String username = resultSet.getString("username");
//                System.out.println("Username: " + username);
//                // process other columns
//            }
//            // Close the resources
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        //1. Test the GenericDAOImpl for create method
//        Connection connection = DatabaseConnection.getConnection();
//        GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connection, User.class);
//
//        //Create a new user
//        User user5 = new User(5, "kirstein.jean", "jean.kirstein@example.com", "mpcozyinterior", "Jean", "Kirstein", LocalDate.of(1990, 9, 15), LocalDateTime.now(), LocalDateTime.now());
//        try {
//            userDAO.create(user5);
//            System.out.println("User created and inserted into the database.");
//        } catch (Exception e) {
//            System.err.println("An error occurred while creating the user:");
//            e.printStackTrace();
//        }

//        // 2. Test the GenericDAOImpl for getById method
//        Connection connection = DatabaseConnection.getConnection();
//        GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connection, User.class);
//
//        //Get user by ID
//        int userId = 3;
//        User user = userDAO.getById(userId);
//
//        if (user != null) {
//            System.out.println("User found: ");
//            System.out.println(user);
//        } else {
//            System.out.println("User not found.");
//        }

//
//        // 3. Tst the GenericDAOImpl update(T entity) method
//        Connection connection = DatabaseConnection.getConnection();
//        GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connection, User.class);
//
//        // Create a User object with the original data
//        User user = new User(1, "john123", "john@example.com", "oldpassword", "John", "Doe",
//                LocalDate.of(1990, 5, 15), LocalDateTime.now(), LocalDateTime.now());
//
//        // Set the updated values for the user
//        user.setEmail("john.doe@example.com");
//        user.setPassword("newpassword");
//
//        // Call the update method
//        userDAO.update(user);
//
//        // Check the updated data in the database or log statements
//        // Retrieve the user from the database and print its properties
//        User updatedUser = userDAO.getById(user.getUserId());
//        System.out.println(updatedUser);

//        // 4. Test the GenericDAOImpl of delete(T entity) method
//        //Connect to the DB
//        Connection connection = DatabaseConnection.getConnection();
//        //Create an instance of the GenericDAOImpl with the User class
//        GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connection, User.class);
//
//        //Create a new user to be deleted
//        User userToDelete = new User(5, "kirstein.jean", "jean.kirstein@example.com", "mpcozyinterior", "Jean", "Kirstein", LocalDate.of(1990, 9, 15), LocalDateTime.now(), LocalDateTime.now());
//
//        try {
//            //Create the user in the db
//            userDAO.create(userToDelete);
//            System.out.println("User created and inserted into the database.");
//            //Delete the user from the db
//            userDAO.delete(userToDelete);
//            System.out.println("User deleted from the db");
//        } catch (Exception e) {
//            System.err.println("An error occured while deleting the user: ");
//            e.printStackTrace();
//        }

//        // 5. Test the getAll method
//        // Instantiate the GenericDAOImpl and other dependencies
//        Connection connection = DatabaseConnection.getConnection();
//        GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connection, User.class);
//
//        // Call the getAll() method
//        UserService userService = new UserService(userDAO);
//
//        //Call the getAllUsers() method
//        List<User> userList = userService.getAllUsers();
//
//        // Verify the results
//        System.out.println("All Users:");
//        for (User user : userList) {
//            System.out.println(user);
//        }


        // Homework 15 - Test the DOM parser
        // Users
        String UsersXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Users.xml";
        String UsersXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\UserSchema.xsd";
        XMLParser.parseXMLWithXSD(UsersXML, UsersXSD);

        // Accounts
        String AccountsXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Accounts.xml";
        String AccountsXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\AccountSchema.xsd";
        XMLParser.parseXMLWithXSD(AccountsXML, AccountsXSD);

        // Orders
        String OrdersXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Orders.xml";
        String OrdersXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\OrderSchema.xsd";
        XMLParser.parseXMLWithXSD(OrdersXML, OrdersXSD);

        // Holdings
        String HoldingsXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Holdings.xml";
        String HoldingsXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\HoldingSchema.xsd";
        XMLParser.parseXMLWithXSD(HoldingsXML, HoldingsXSD);

        // Stocks
        String StocksXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Stocks.xml";
        String StocksXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\StockSchema.xsd";
        XMLParser.parseXMLWithXSD(StocksXML, StocksXSD);
    }
}