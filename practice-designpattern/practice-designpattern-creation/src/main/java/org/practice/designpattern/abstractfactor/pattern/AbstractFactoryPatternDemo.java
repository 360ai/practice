package org.practice.designpattern.abstractfactor.pattern;


public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("rectangle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("circle");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("square");
        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("red");
        Color color2 = colorFactory.getColor("green");
        Color color3 = colorFactory.getColor("blue");
        color1.fill();
        color2.fill();
        color3.fill();
    }
}
