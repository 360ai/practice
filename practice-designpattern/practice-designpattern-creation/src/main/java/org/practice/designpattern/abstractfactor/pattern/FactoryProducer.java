package org.practice.designpattern.abstractfactor.pattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType.equals("color")) {
            return new ColorFactory();
        } else if (factoryType.equals("shape")) {
            return new ShapFactory();
        }
        return null;
    }
}
