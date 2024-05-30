package com.wipro.Assignments;

public class MainApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        Shape shape1 = shapeFactory.createShape("CIRCLE");
        shape1.draw();
        
        Shape shape2 = shapeFactory.createShape("SQUARE");
        shape2.draw();
        
        Shape shape3 = shapeFactory.createShape("RECTANGLE");
        shape3.draw();
    }
}

