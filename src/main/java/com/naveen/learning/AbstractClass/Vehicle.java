package com.naveen.learning.AbstractClass;

// Abstract class na complete + incomplete methods irukkalam
public abstract class Vehicle {

    // Common variable - all vehicle-ku brand irukkum
    String brand;

    // Constructor - object create aagumbothu child class moolama call aagum
    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor called for: " + brand);
    }

    // Concrete method / implemented method
    // Idhu already implementation irukkura method
    public void startVehicle() {
        System.out.println(brand + " vehicle is starting...");
    }

    // Concrete method
    public void stopVehicle() {
        System.out.println(brand + " vehicle is stopping...");
    }

    // Abstract method / unimplemented method
    // Body illa. Child class compulsory implement pannanum
    public abstract void fuelType();

    // Abstract method
    public abstract void numberOfWheels();
}