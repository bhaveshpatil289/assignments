package com.wipro.Assignments;

import java.io.Serializable;

public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L;
    private double number1;
    private double number2;
    private String operation;

    public Calculation(double number1, double number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return number1 + " " + operation + " " + number2;
    }
}




