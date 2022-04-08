package org.practice.designpattern.abstractfactor.pattern;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method!");
    }
}
