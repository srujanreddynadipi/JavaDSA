package com.prepInsta.java.Cubiod;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle= new Rectangle(2,3);
        System.out.println("rectangle length ="+ rectangle.getLength());
        System.out.println("rectangle width ="+ rectangle.getWidth());
        System.out.println("area= " + rectangle.getArea());
        Cubiod cuboid=new Cubiod(4,7, 5);
        System.out.println("height= " + cuboid.getHeight());
        System.out.println("cuboid volume= " +cuboid.getVolume());
    }
}
