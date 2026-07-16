package org.example.core;

public class xuv extends vehicle{
    public xuv(int r, String s, String m){
        super(2000, r, s, "xuv", m);
    }
    public int calculateFare(int t){
        return 2000 + (t * 100);
    }

}
