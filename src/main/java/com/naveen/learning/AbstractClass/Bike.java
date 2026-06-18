package com.naveen.learning.AbstractClass;

// Bike is child class of Vehicle
public class Bike extends Vehicle {

    public Bike(String brand) {
        super(brand);
    }

    @Override
    public void fuelType() {
        System.out.println(brand + " bike uses Petrol.");
    }

    @Override
    public void numberOfWheels() {
        System.out.println(brand + " bike has 2 wheels.");
    }

    public void kickStart() {
        System.out.println(brand + " bike kick start enabled.");
    }
}