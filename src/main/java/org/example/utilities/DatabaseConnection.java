package org.example.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/financialmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "murakami4625196!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}
