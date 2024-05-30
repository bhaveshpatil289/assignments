package com.wipro.Assignments;

import java.io.*;

class CustomObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public CustomObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        // Create a custom object
        CustomObject obj = new CustomObject("John", 30);

        // Serialize the object to a file
        String filename = "custom_object.ser";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            System.out.println("Custom object serialized and saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // Deserialize the object from the file
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            CustomObject restoredObj = (CustomObject) objectIn.readObject();
            System.out.println("Custom object deserialized from file:");
            System.out.println("Name: " + restoredObj.getName());
            System.out.println("Age: " + restoredObj.getAge());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




