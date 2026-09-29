package org.example.core;

public class LuxurySedan extends Vehicle {
    public LuxurySedan(int regNo, String model, String driverName) {
        super(1000, regNo, model, "LuxurySedan", driverName);
    }

    @Override
    public int calculateFare(int time) {
        return 1000 + (time * 50);
    }
}