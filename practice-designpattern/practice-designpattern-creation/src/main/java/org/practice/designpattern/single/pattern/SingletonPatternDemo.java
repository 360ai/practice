package org.practice.designpattern.single.pattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
        Singleton singleton=Singleton.getInstance();
        singleton.showMessage();
    }
}
