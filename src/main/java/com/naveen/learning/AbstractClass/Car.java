package com.naveen.learning.AbstractClass;

// Car is child class of Vehicle
public class Car extends Vehicle {

    // Child constructor
    public Car(String brand) {
        super(brand); // Parent Vehicle constructor-ku brand pass panrom
    }

    // Abstract method implementation
    @Override
    public void fuelType() {
        System.out.println(brand + " car uses Petrol/Diesel.");
    }

    // @Override = "Java-kitta solrathu: naan parent method ah thaan re-define
    // panren, please verify pannu!" — ithu oru safety check annotation, not
    // compulsory but highly recommended. 🛡️

    @Override // It is overridden because it is compulsory to IMPLEMENT all abstract methods
              // when extending an abstract class
    public void numberOfWheels() {
        System.out.println(brand + " car has 4 wheels.");
    }

    // Car-specific method
    public void openSunroof() {
        System.out.println(brand + " car sunroof opened.");
    }
}