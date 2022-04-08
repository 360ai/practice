package org.practice.designpattern.factory.pattern;

public class FactoryPatternDemo {
    public static void  main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1=shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2=shapeFactory.getShape("SQURE");
        shape2.draw();
        Shape shape3= shapeFactory.getShape("CIRCLE");
        shape3.draw();
    }
}
