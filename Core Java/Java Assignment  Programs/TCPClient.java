package com.wipro.Assignments;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            // Prepare and send serialized object to server
            Calculation calculation = new Calculation(2, 2, "+");
            objectOutputStream.writeObject(calculation);
            objectOutputStream.flush();
            System.out.println("Sent: " + calculation);

            // Receive result from server
            double result = objectInputStream.readDouble();
            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




