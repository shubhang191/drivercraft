package org.example.core;

public abstract class vehicle {
    int baseFare;
    int regno;
    String drivername;
    String type;
    String model;
    public vehicle(int b, int r ,String m, String t, String d){
        this.baseFare = b;
        this.regno = r;
        this.drivername = d;
        this.type = t;
        this.model = m;
    }
    public int getfare(){ return baseFare; }
    public int getregno(){ return regno; }
    public String getname(){ return drivername; }
    public String gettype() { return type; }
    public abstract int calculateFare(int time);
}
