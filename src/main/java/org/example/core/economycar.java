package org.example.core;

public class economycar extends vehicle{
    public economycar(int r, String s, String m){
        super(500, r, s, "economycar", m);
    }
    @Override
    public int calculateFare(int t){
        return 500 + (t * 20);
    }
}
