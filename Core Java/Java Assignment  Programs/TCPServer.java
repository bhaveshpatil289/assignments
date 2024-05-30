package com.wipro.Assignments;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server waiting for client on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                // Read serialized object from client
                Calculation calculation = (Calculation) objectInputStream.readObject();
                System.out.println("Received: " + calculation);

                // Perform calculation
                double result;
                switch (calculation.getOperation()) {
                    case "+":
                        result = calculation.getNumber1() + calculation.getNumber2();
                        break;
                    case "-":
                        result = calculation.getNumber1() - calculation.getNumber2();
                        break;
                    case "*":
                        result = calculation.getNumber1() * calculation.getNumber2();
                        break;
                    case "/":
                        result = calculation.getNumber1() / calculation.getNumber2();
                        break;
                    default:
                        result = 0;
                }

                // Send result back to client
                objectOutputStream.writeDouble(result);
                objectOutputStream.flush();

                // Close streams and socket
                objectOutputStream.close();
                objectInputStream.close();
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




