package org.example.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    public static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static final int INITIAL_POOL_SIZE = 10;

    private final BlockingQueue<Connection> connections;

    public ConnectionPool() {
        connections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            Connection connection = createConnection();
            connections.offer(connection);
        }
    }

    public Connection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to obtain a connection from the pool.", e);
        }
    }

    public void returnConnection(Connection connection) {
        connections.offer(connection);
    }

    private Connection createConnection() {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream("C:\\Users\\Owner\\OneDrive\\Documents\\GitHub\\FinancialManagement\\src\\main\\resources\\db.properties")) {
            props.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
            );
        } catch (SQLException e) {
            LOGGER.error("Error getting the connection:", e);
            throw new RuntimeException("Failed to create a database connection.", e);
        }
    }

    public void close() {
        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Error closing the connection:", e);
            }
        }
    }
}
