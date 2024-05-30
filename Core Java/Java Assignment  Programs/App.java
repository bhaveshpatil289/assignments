package com.wipro.Assignments;

import java.sql.Connection;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
        // Get the singleton instance of the DatabaseConnectionManager
        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        
        // Get the database connection
        Connection connection = dbManager.getConnection();


        // Use the connection as needed (for example, to perform a query)
        // For demonstration, we'll just print a message
        System.out.println("Successfully connected to the database.");


        // Remember to close the connection when done
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






