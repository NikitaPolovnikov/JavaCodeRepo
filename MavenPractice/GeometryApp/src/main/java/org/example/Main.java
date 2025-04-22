package org.example;

import org.example.Circle;
import org.example.Rectangle;
import org.example.Triangle;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4, 5);

        printShapeInfo(circle, "Circle");
        printShapeInfo(rectangle, "Rectangle");
        printShapeInfo(triangle, "Triangle");
    }

    private static void printShapeInfo(Shape shape, String name) {
        System.out.println(name + ":");
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println();
    }
}