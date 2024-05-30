package com.wipro.Assignments;

public class ExampleClass {
    private int privateField;

    public ExampleClass(int privateField) {
        this.privateField = privateField;
    }

    private void privateMethod() {
        System.out.println("Private Method called");
    }

    public void publicMethod() {
        System.out.println("Public Method called");
    }

    public int getPrivateField() {
        return privateField;
    }
}




