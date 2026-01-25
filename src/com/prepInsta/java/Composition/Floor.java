package com.prepInsta.java.Composition;

public class Floor {
    private int floorNo;
    private double floorCapacity;

    public Floor(int floorNo, double floorCapacity) {
        this.floorNo = floorNo;
        this.floorCapacity = floorCapacity;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public double getFloorCapacity() {
        return floorCapacity;
    }

    public void Cleanthefloor(){
        System.out.println("Cleaning Process Initiated");
    }
}
