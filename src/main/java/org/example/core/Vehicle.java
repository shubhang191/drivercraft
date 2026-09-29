package org.example.core;

public abstract class Vehicle {
    private int baseFare;
    private int regNo;
    private String driverName;
    private String type;
    private String model;

    public Vehicle(int baseFare, int regNo, String model, String type, String driverName) {
        this.baseFare = baseFare;
        this.regNo = regNo;
        this.model = model;
        this.type = type;
        this.driverName = driverName;
    }

    public int getBaseFare() { return baseFare; }
    public int getRegNo() { return regNo; }
    public String getDriverName() { return driverName; }
    public String getType() { return type; }
    public String getModel() { return model; }

    public abstract int calculateFare(int time);

    @Override
    public String toString() {
        return type + " [RegNo=" + regNo + ", Model=" + model + ", Driver=" + driverName + "]";
    }
}