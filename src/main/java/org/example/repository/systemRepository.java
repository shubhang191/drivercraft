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
    public void assign(vehicle v){
        db.assignvehicle(v);
    }
    public int vehiclesizerepo(){
        return db.vehiclesize();
    }
    public int bookedvehiclesizerepo(){
        return db.bookedvehiclesize();
    }
    public boolean searchtypevehiclesrepo(vehicle v){
        for(int i=0; i<db.vehiclesize(); i++){
            if(v.gettype().equalsIgnoreCase(db.getvehicle(i).gettype())){
                return true;
            }
        }
        return false;
    }
    public boolean searchtypebookedvehiclesrepo(vehicle v){
        for(int i=0; i<db.bookedvehiclesize(); i++){
            if(v.gettype().equalsIgnoreCase(db.getbookedvehicle(i).gettype())){
                return true;
            }
        }
        return false;
    }
    public void disp(){
        db.displayvehicle();
    }
}
