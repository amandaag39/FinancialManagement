package org.example;

import org.example.dao.GenericDAO;
import org.example.dao.GenericDAOImpl;
import org.example.model.*;
import org.example.parsers.DOMParser;
import org.example.parsers.XMLParser;
import org.example.services.UserService;
import org.example.utilities.ConnectionPool;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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






        // Homework 14 - revision: add ConnectionPool

        // Create a connection pool with desired configurations
        ConnectionPool connectionPool = new ConnectionPool();

        // Create an instance of your DAO using the connection pool
        GenericDAO<User> userDao = new GenericDAOImpl<>(connectionPool, User.class);


        // 1. Test the getById method
        int entityId = 3; // Replace with the ID of the entity you want to retrieve
        User retrievedEntity = userDao.getById(entityId);
        if (retrievedEntity != null) {
            System.out.println("Retrieved entity: " + retrievedEntity);
        } else {
            System.out.println("Entity with ID " + entityId + " not found.");
        }


//        // 2. Test the create method
//        // Create a new instance of the User entity
//        User user = new User(5, "kirstein.jean", "jean.kirstein@example.com", "mpcozyinterior", "Jean", "Kirstein", LocalDate.of(1990, 9, 15), LocalDateTime.now(), LocalDateTime.now());
//
//        // Call the create method
//        userDao.create(user);
//
//        // Verify if the User entity was inserted successfully
//        User retrievedUser = userDao.getById(5);
//        if (retrievedUser != null) {
//            System.out.println("User created successfully: " + retrievedUser);
//        } else {
//            System.out.println("Failed to create User.");
//        }


        // 3. Test update method
//        // Create a connection pool with desired configurations
//        ConnectionPool connectionPool = new ConnectionPool();
//
//        // Create an instance of your DAO using the connection pool
//        GenericDAO<User> userDao = new GenericDAOImpl<>(connectionPool, User.class);
//
//        try {
//            // Create a User object with the original data
//            User user = new User(14, "armin.arlert", "armin@example.com", "kireinaumi", "Armin", "Arlert",
//                    LocalDate.of(2007, 4, 12), LocalDateTime.now(), LocalDateTime.now());
//
//            // Call the create method
//            userDao.create(user);
//
//            // Set the updated values for the user
//            user.setEmail("arminarmout@example.com");
//            user.setPassword("newpassy");
//
//            // Call the update method
//            userDao.update(user);
//
//            // Retrieve the user from the database and print its properties
//            User updatedUser = userDao.getById(user.getUserId());
//            if (updatedUser != null) {
//                System.out.println("User updated successfully: " + updatedUser);
//            } else {
//                System.out.println("Failed to update User.");
//            }
//        } catch (Exception e) {
//            System.err.println("An error occurred while performing operations:");
//            e.printStackTrace();
//        } finally {
//            // Release the resources held by the connection pool
//            connectionPool.close();
//        }"

//        // 4. Test delete method
//        // Create a connection pool with desired configurations
//        ConnectionPool connectionPool = new ConnectionPool();
//
//        // Create an instance of your DAO using the connection pool
//        GenericDAO<User> userDao = new GenericDAOImpl<>(connectionPool, User.class);
//
//        try {
//            // Create a User object with the ID of the user to be deleted
//            User userToDelete = new User();
//            userToDelete.setUserId(13); // Set the ID of the user to be deleted
//
//            // Delete the user from the database
//            userDao.delete(userToDelete);
//            System.out.println("User deleted from the database.");
//        } catch (Exception e) {
//            System.err.println("An error occurred while deleting the user:");
//            e.printStackTrace();
//        } finally {
//            // Release the resources held by the connection pool
//            connectionPool.close();
//        }





//        // Homework 15 - Test the DOM parser
//        // Users
//        String UsersXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Users.xml";
//        String UsersXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\UserSchema.xsd";
//        XMLParser.parseXMLWithXSD(UsersXML, UsersXSD);
//
//        // Accounts
//        String AccountsXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Accounts.xml";
//        String AccountsXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\AccountSchema.xsd";
//        XMLParser.parseXMLWithXSD(AccountsXML, AccountsXSD);
//
//        // Orders
//        String OrdersXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Orders.xml";
//        String OrdersXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\OrderSchema.xsd";
//        XMLParser.parseXMLWithXSD(OrdersXML, OrdersXSD);
//
//        // Holdings
//        String HoldingsXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Holdings.xml";
//        String HoldingsXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\HoldingSchema.xsd";
//        XMLParser.parseXMLWithXSD(HoldingsXML, HoldingsXSD);
//
//        // Stocks
//        String StocksXML = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Stocks.xml";
//        String StocksXSD = "C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XSD Files\\StockSchema.xsd";
//        XMLParser.parseXMLWithXSD(StocksXML, StocksXSD);



//        // Homework 16 - JAXB
//
//        // Parse users.xml
//        try {
//            // 1. Create an instance of the JAXBContext for root class
//            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class); // Pass the class you want to unmarshal
//
//            // 2. Create an instance of 'Unmarshaller' from the JAXBContext object
//            Unmarshaller usersUnmarshaller = jaxbContext.createUnmarshaller();
//
//            // 3. Use the 'Unmarshaller' to unmarshal the XML data
//            File xmlFile = new File("C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Users.xml");
//            Users unmarshalledUsers = (Users) usersUnmarshaller.unmarshal(xmlFile);
//
//            // 4. Access the parsed data
//            List<User> userList = unmarshalledUsers.getUserList();
//            System.out.println(userList);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//        // parse accounts.xml
//
//        try {
//            // 1. Create an instance of the JAXBContext for root class
//            JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class); // Pass the class you want to unmarshal
//
//            // 2. Create an instance of 'Unmarshaller' from the JAXBContext object
//            Unmarshaller accountsUnmarshaller = jaxbContext.createUnmarshaller();
//
//            // 3. Use the 'Unmarshaller' to unmarshal the XML data
//            File xmlFile = new File("C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Accounts.xml");
//            Accounts unmarshalledAccounts = (Accounts) accountsUnmarshaller.unmarshal(xmlFile);
//
//            // 4. Access the parsed data
//            List<Account> accountList = unmarshalledAccounts.getAccountList();
//            System.out.println(accountList);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//        //parse stocks.xml
//
//        try {
//            // 1. Create an instance of the JAXBContext for root class
//            JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class); // Pass the class you want to unmarshal
//
//            // 2. Create an instance of 'Unmarshaller' from the JAXBContext object
//            Unmarshaller stocksUnmarshaller = jaxbContext.createUnmarshaller();
//
//            // 3. Use the 'Unmarshaller' to unmarshal the XML data
//            File xmlFile = new File("C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\XML Files\\Stocks.xml");
//            Stocks unmarshalledStocks = (Stocks) stocksUnmarshaller.unmarshal(xmlFile);
//
//            // 4. Access the parsed data
//            List<Stock> stockList = unmarshalledStocks.getStockList();
//            System.out.println(stockList);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }
}