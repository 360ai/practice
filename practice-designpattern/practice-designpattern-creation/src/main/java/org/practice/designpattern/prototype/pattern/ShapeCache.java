package org.practice.designpattern.prototype.pattern;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<Integer, Shape> shapeHashtable = new Hashtable<>();

    public static Shape getShape(Integer id) {
        Shape shape = shapeHashtable.get(id);
        return shape;
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId(1);
        shapeHashtable.put(circle.getId(), circle);
        Rectangle rectangle = new Rectangle();
        rectangle.setId(2);
        shapeHashtable.put(rectangle.getId(), rectangle);
        Square square = new Square();
        square.setId(3);
        shapeHashtable.put(square.getId(), square);
    }
}
