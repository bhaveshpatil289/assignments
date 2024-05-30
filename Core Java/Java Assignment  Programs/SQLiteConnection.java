package com.wipro.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static void main(String[] args) {
        // SQLite connection string
        String url = "jdbc:sqlite:sample.db";
        
        // Load the SQLite JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
            e.printStackTrace();
            return;
        }
        
        // Connect to the database
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("A connection to the SQLite database has been established.");
                System.out.println("Connection object: " + conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}




