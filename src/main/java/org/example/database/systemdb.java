package org.example.database;

import org.example.core.vehicle;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class systemdb {
    private List<vehicle> vehicles = new ArrayList<>();
    private List<vehicle> bookedvehicles  = new ArrayList<>();


    public void addvehicle(vehicle v){
        vehicles.add(v);
    }
    public void removevehiclefromfleet(vehicle v){
        for(vehicle V : vehicles){
            if(V.gettype().equalsIgnoreCase(v.gettype())){
                vehicles.remove(v);
                break;
            }
        }
    }
    public void assignvehicle(vehicle v){
        bookedvehicles.add(v);
        vehicles.remove(v);
    }
    public int vehiclesize(){
      return vehicles.size();
    }
    public int bookedvehiclesize(){
        return bookedvehicles.size();
    }
    public vehicle getvehicle(int i){
        return vehicles.get(i);
    }
    public vehicle getbookedvehicle(int i){
        return bookedvehicles.get(i);
    }
    public boolean searchtypevehicles(vehicle v){
        for(int i=0; i<vehiclesize(); i++){
            if(v.gettype().equalsIgnoreCase(vehicles.get(i).gettype())){
                return true;
            }
        }
        return false;
    }
    public boolean searchtypebookedvehicles(vehicle v){
        for(int i=0; i<bookedvehiclesize(); i++){
            if(v.gettype().equalsIgnoreCase(bookedvehicles.get(i).gettype())){
                return true;
            }
        }
        return false;
    }
    public void displayvehicle(){
        System.out.println("List of vehicles available: ");
        for(vehicle v : vehicles){
            System.out.println(v);
        }
    }
}
