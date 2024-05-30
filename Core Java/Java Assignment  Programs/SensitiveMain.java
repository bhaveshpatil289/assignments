package com.wipro.Assignments;

public class SensitiveMain {
    public static void main(String[] args) {
        String secretKey = "superSecretKey123";
        String correctPassword = "password123";


        SensitiveObjectProxy proxy = new SensitiveObjectProxy(secretKey, correctPassword);


        try {
            // Attempt to access the secret key with the correct password
            System.out.println("Accessing with correct password: " + proxy.getSecretKey("password123"));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }


        try {
            // Attempt to access the secret key with an incorrect password
            System.out.println("Accessing with incorrect password: " + proxy.getSecretKey("wrongPassword"));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}

