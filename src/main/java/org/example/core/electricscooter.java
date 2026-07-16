package org.example.core;

public class electricscooter extends vehicle{
    public electricscooter(int r, String s, String m){
        super(100, r, s, "electicscooter", m);
    }
    public int calculateFare(int t){
        return 100 + (t * 10);
    }

}
