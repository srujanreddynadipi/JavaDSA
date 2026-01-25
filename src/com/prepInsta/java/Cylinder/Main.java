package com.prepInsta.java.Cylinder;
import  com.prepInsta.java.Cylinder.Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3.75);
        System.out.println("circle radius is"+ circle.getRadius());
        System.out.println("circle Area is"+ circle.getArea());
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("Cylinder Height is"+ cylinder.getHeight());
        System.out.println("Cylinder radius is"+ cylinder.getRadius());
        System.out.println("circle area is"+ cylinder.getArea());
        System.out.println("cylinder Volume  is"+ cylinder.getVolume());


    }
}
