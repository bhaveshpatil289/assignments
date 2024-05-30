package com.wipro.Assignments;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuthentication {

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
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter User ID: ");
            String userID = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            String hashedPassword = hashPassword(password);

            if (choice == 1) {
                if (registerUser(con, userID, hashedPassword)) {
                    System.out.println("User registered successfully.");
                } else {
                    System.out.println("User registration failed. User ID might already exist.");
                }
            } else if (choice == 2) {
                if (checkUser(con, userID, hashedPassword)) {
                    System.out.println("User access allowed.");
                } else {
                    System.out.println("User access denied.");
                }
            } else {
                System.out.println("Invalid choice.");
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE Users (UserID VARCHAR2(50) PRIMARY KEY, Password VARCHAR2(64))";
        try (PreparedStatement stmt = con.prepareStatement(createTableSQL)) {
            stmt.execute();
        } catch (SQLException e) {
            // If table already exists, we just ignore the exception
            if (!e.getMessage().contains("ORA-00955")) {
                throw e;
            }
        }
    }

    private static boolean registerUser(Connection con, String userID, String hashedPassword) throws SQLException {
        String insertSQL = "INSERT INTO Users (UserID, Password) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            stmt.setString(1, userID);
            stmt.setString(2, hashedPassword);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // If user already exists, this will throw an exception
            if (e.getMessage().contains("ORA-00001")) {
                return false;
            } else {
                throw e;
            }
        }
    }

    private static boolean checkUser(Connection con, String userID, String hashedPassword) throws SQLException {
        String selectSQL = "SELECT * FROM Users WHERE UserID = ? AND Password = ?";
        try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
            stmt.setString(1, userID);
            stmt.setString(2, hashedPassword);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.", e);
        }
    }
}


