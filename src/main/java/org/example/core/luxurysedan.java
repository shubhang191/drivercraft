package org.example.core;

public class luxurysedan extends vehicle{
    public luxurysedan(int r, String s, String m){
        super(1000, r, s, "luxurysedan", m);
    }
    public int calculateFare(int t){
        return 1000 + (t * 50);
    }
}
