package org.example.core;

public class Xuv extends Vehicle {
    public Xuv(int regNo, String model, String driverName) {
        super(2000, regNo, model, "XUV", driverName);
    }

    @Override
    public int calculateFare(int time) {
        return 2000 + (time * 100);
    }
}