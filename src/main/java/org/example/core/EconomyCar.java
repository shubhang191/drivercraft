package org.example.core;

public class EconomyCar extends Vehicle {
    public EconomyCar(int regNo, String model, String driverName) {
        super(500, regNo, model, "EconomyCar", driverName);
    }

    @Override
    public int calculateFare(int time) {
        return 500 + (time * 20);
    }
}