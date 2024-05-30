package com.wipro.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

    private static final String URL = "jdbc:oracle:thin:@localhost:9501/XE";
    private static final String USER = "system";
    private static final String PASSWORD = "rps@123";

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(con);
            insertTestData(con);
            
            // Run SELECT query using PreparedStatement
            String selectQuery = "SELECT * FROM TestTable WHERE id = ?";
            try (PreparedStatement stmt = con.prepareStatement(selectQuery)) {
                // Set parameter value
                stmt.setInt(1, 1); // Assuming we want to retrieve data for id = 1
                
                // Execute query
                try (ResultSet rs = stmt.executeQuery()) {
                    // Process result set
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        System.out.println("ID: " + id + ", Name: " + name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE TestTable (id NUMBER, name VARCHAR2(50))";
        try (PreparedStatement stmt = con.prepareStatement(createTableSQL)) {
            stmt.execute();
        } catch (SQLException e) {
            // If table already exists, we just ignore the exception
            if (!e.getMessage().contains("ORA-00955")) {
                throw e;
            }
        }
    }

    private static void insertTestData(Connection con) throws SQLException {
        String insertSQL = "INSERT INTO TestTable (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            // Inserting test data
            stmt.setInt(1, 1);
            stmt.setString(2, "John Doe");
            stmt.executeUpdate();
            
            stmt.setInt(1, 2);
            stmt.setString(2, "Jane Smith");
            stmt.executeUpdate();
            
            stmt.setInt(1, 3);
            stmt.setString(2, "Alice");
            stmt.executeUpdate();
        }
    }
}




