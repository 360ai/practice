package org.practice.designpattern.single.pattern;

public class SingleObject {
    public static SingleObject singleObject = new SingleObject();
    private SingleObject(){

    }
    public  static SingleObject getInstance(){
        return singleObject;
    }
    public void showMessage(){
        System.out.println("hello world!");
    }
}
