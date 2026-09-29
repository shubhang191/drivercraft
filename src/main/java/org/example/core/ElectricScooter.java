package org.example.core;

public class ElectricScooter extends Vehicle {
    public ElectricScooter(int regNo, String model, String driverName) {
        super(100, regNo, model, "ElectricScooter", driverName);
    }

    @Override
    public int calculateFare(int time) {
        return 100 + (time * 10);
    }
}