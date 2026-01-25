package com.prepInsta.java.inheritance;

abstract class Vehicle {
    abstract public void brake();

    protected void clutch() {
        System.out.println("clutch");
    }
}

class Car extends Vehicle {
    public void brake() {
        System.out.println("Brake system");
    }
}

class UPI implements  ATM{

    @Override
    public void payment() {
        System.out.println("Trans");
    }
}

public class Abstract1 {
    public static void main(String[] args) {

        Car myCar = new Car();

        myCar.brake();
        myCar.clutch();

        UPI upi = new UPI();
        upi.payment();
    }
}
