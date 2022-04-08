package org.practice.designpattern.prototype.pattern;

import lombok.Data;

@Data
public abstract class Shape implements Cloneable {
    protected String type;
    private int id;

    abstract void draw();

    @Override
    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        }
        return object;
    }

}
