package org.practice.designpattern.abstractfactor.pattern;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangele::draw() method!");
    }
}
