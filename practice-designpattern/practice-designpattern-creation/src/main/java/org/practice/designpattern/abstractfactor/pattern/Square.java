package org.practice.designpattern.abstractfactor.pattern;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method!");
    }
}
