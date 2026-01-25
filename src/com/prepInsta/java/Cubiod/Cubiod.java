package com.prepInsta.java.Cubiod;
import com.prepInsta.java.Cubiod.Rectangle;

public class Cubiod extends Rectangle {

    private double height;

    public Cubiod(double length, double width, double height) {
        super(length, width);
        this.height = (height < 0) ? 0 : height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}
