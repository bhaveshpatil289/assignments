package com.wipro.Assignments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // Inspecting methods
        Method[] methods = ExampleClass.class.getDeclaredMethods();
        System.out.println("Methods of ExampleClass:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Inspecting fields
        Field[] fields = ExampleClass.class.getDeclaredFields();
        System.out.println("\nFields of ExampleClass:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // Inspecting constructors
        Constructor[] constructors = ExampleClass.class.getDeclaredConstructors();
        System.out.println("\nConstructors of ExampleClass:");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        // Modifying private field and setting its value during runtime
        ExampleClass instance = new ExampleClass(10);
        Field privateField = ExampleClass.class.getDeclaredField("privateField");
        privateField.setAccessible(true); // Set accessibility of private field to true
        privateField.setInt(instance, 20); // Set the value of private field

        // Checking the modified value
        System.out.println("\nModified privateField value: " + instance.getPrivateField());
    }
}




