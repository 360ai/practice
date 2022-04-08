package org.practice.designpattern.abstractfactor.pattern;

public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color.equals("red")){
            return new Red();
        }else if(color.equals("green")){
            return new Green();
        }else if(color.equals("blue")){
            return new Blue();
        }
        return null;
    }
}
