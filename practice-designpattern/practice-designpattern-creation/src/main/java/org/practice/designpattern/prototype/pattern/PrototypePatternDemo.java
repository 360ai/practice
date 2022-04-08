package org.practice.designpattern.prototype.pattern;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape1 = ShapeCache.getShape(1);
        shape1.draw();
        Shape shape2 = ShapeCache.getShape(2);
        shape2.draw();
        Shape shape3 = ShapeCache.getShape(3);
        shape3.draw();
    }
}
