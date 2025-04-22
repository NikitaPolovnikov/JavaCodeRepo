package org.example;

public class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    public double calculateArea() {
        return length * width;
    }


    public double calculatePerimeter() {
        return (length+width)*2;
    }
}
