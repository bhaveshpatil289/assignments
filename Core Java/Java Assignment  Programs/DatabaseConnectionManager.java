package com.wipro.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {
    // Static variable to hold the single instance of the class
    private static DatabaseConnectionManager instance;


    // Database connection
    private Connection connection;


    // Database credentials
    private static final String URL = "jdbc:oracle:thin:@localhost:9501/XE";
    private static final String USER = "system";
    private static final String PASSWORD = "rps@123";
    private static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver";


    // Private constructor to prevent instantiation
    private DatabaseConnectionManager() {
        try {
            // Load the database driver
            Class.forName(DRIVER_CLASS);
            // Establish the connection
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }


    // Public method to provide access to the instance
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }


    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}






