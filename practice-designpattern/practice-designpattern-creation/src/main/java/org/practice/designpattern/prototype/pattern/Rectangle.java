package org.practice.designpattern.prototype.pattern;

public class Rectangle extends Shape {
    public Rectangle() {
        type = "rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method!");
    }
}
