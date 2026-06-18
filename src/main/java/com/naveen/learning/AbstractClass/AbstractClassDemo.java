package com.naveen.learning.AbstractClass;

public class AbstractClassDemo {

    public static void main(String[] args) {

        System.out.println("===== Abstract Class Demo Started =====");

        // Vehicle v = new Vehicle("Test");
        // Above line not allowed because abstract class object create panna mudiyadhu

        System.out.println("\n--- Car Object ---");
        Car car = new Car("Honda");
        car.startVehicle();
        car.fuelType();
        car.numberOfWheels();
        car.openSunroof();
        car.stopVehicle();

        System.out.println("\n--- Bike Object ---");
        Bike bike = new Bike("Yamaha");
        bike.startVehicle();
        bike.fuelType();
        bike.numberOfWheels();
        bike.kickStart();
        bike.stopVehicle();

        System.out.println("\n===== Abstract Class Demo Completed =====");
    }
}