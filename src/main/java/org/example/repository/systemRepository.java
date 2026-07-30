package org.example.repository;

import org.example.core.vehicle;
import org.example.database.systemdb;
import org.springframework.stereotype.Repository;

@Repository
public class systemRepository {
    private final systemdb db;

    public systemRepository(systemdb db){
        this.db = db;
    }
    public void save(vehicle v){
        db.addvehicle(v);
    }
    public void assign(String s){
        db.assignvehicle(s);
    }
    public vehicle getvehiclerepo(int i){
        return db.getvehicle(i);
    }
    public vehicle getbookedvehiclerepo(int i){
        return db.getbookedvehicle(i);
    }
    public int vehiclesizerepo(){
        return db.vehiclesize();
    }
    public int bookedvehiclesizerepo(){
        return db.bookedvehiclesize();
    }
    public int getcarbytyperepo(String s){ return db.getcarbytype(s); }
    public int getbookedcarbytyperepo(String s){ return db.getbookedcarbytype(s); }
    public int getfareofvehiclerepo(String s, int t){ return db.getfareofvehicle(s, t); }
    public void remove(String s){
        db.removevehiclefromfleet(s);
    }
    public void disp(){
        db.displayvehicle();
    }
}
