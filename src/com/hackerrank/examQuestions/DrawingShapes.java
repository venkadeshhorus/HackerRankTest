package com.hackerrank.examQuestions;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


class Shape {
    public void drawShape() {
       System.out.println("Drawing a Shape");
    }
}


class ShapeFactory {
    void drawShape(String drawingTypevrv) {
        if(drawingTypevrv.equalsIgnoreCase("Circle")) {
            new Circle().drawShape();
        } else if(drawingTypevrv.equalsIgnoreCase("Rectangle")) {
            new Rectangle().drawShape();
        } else if(drawingTypevrv.equalsIgnoreCase("Square")) {
            new Square().drawShape();
        } else {
            System.out.println("Drawing " + drawingTypevrv + " is not supported");
        }
    }
}

class Circle extends Shape {
    public void drawShape() {
        System.out.println("Drawing a Circle");
    }
}

class Square extends Shape {
    public void drawShape() {
        System.out.println("Drawing a Square");
    }
}

class Rectangle extends Shape {
    public void drawShape() {
        System.out.println("Drawing a Rectangle");
    }
}

public class DrawingShapes {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle(); 
        ((Shape)circle).drawShape();
        ((Shape)square).drawShape();
        ((Shape)rectangle).drawShape(); 
        System.out.println(); 
        ShapeFactory factory = new ShapeFactory(); 
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = in.next();
            factory.drawShape(type);    
        }
    }
}

