package org.example.database;

import org.example.core.vehicle;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class systemdb {
    private List<vehicle> vehicles = new ArrayList<>();
    private List<vehicle> bookedvehicles  = new ArrayList<>();

    //add and remove vehicles (for admin)
    public void addvehicle(vehicle v){
        vehicles.add(v);
    }
    public void removevehiclefromfleet(String s){
        vehicles.removeIf(v -> v.gettype().equalsIgnoreCase(s));
    }
    //to get a vehicle from fleet before assigning it to a customer
    public vehicle getvehiclefromfleet(String s){
        vehicle transport = null;
        for(int i=0; i<vehiclesize(); i++){
            if(vehicles.get(i).gettype().equalsIgnoreCase(s)){
                transport = vehicles.get(i);
                vehicles.remove(i);
                break;
            }
        }
        return transport;
    }
    //to assign the vehicle to customer
    public void assignvehicle(String s){
        bookedvehicles.add(getvehiclefromfleet(s));
    }
    //to get the count of the type of car; if it's available or not
    public int getcarbytype(String s){
        int count = 0;
        if(s.equalsIgnoreCase("economycar")){
            for(int i=0; i<vehiclesize(); i++){
                if(getvehicle(i).gettype().equalsIgnoreCase("economycar")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("luxurysedan")){
            for(int i=0; i<vehiclesize(); i++){
                if(getvehicle(i).gettype().equalsIgnoreCase("luxurysedan")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("electricscooter")){
            for(int i=0; i<vehiclesize(); i++){
                if(getvehicle(i).gettype().equalsIgnoreCase("electricscooter")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("xuv")){
            for(int i=0; i<vehiclesize(); i++){
                if(getvehicle(i).gettype().equalsIgnoreCase("xuv")){
                    count++;
                }
            }
        }
        else{
            System.out.println("Invalid input");
        }
        return count;
    }
    //to get the count of the type of booked car; if it's available or not
    public int getbookedcarbytype(String s){
        int count = 0;
        if(s.equalsIgnoreCase("economycar")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("economycar")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("luxurysedan")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("luxurysedan")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("electricscooter")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("electricscooter")){
                    count++;
                }
            }
        }
        else if(s.equalsIgnoreCase("xuv")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("xuv")){
                    count++;
                }
            }
        }
        else{
            System.out.println("Invalid input");
        }
        return count;
    }
    //returns fare of the vehicle, taking its type (string) as input
    public int getfareofvehicle(String s, int t){
        int fare = 0;
        if(s.equalsIgnoreCase("economycar")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("economycar")){
                    fare = getbookedvehicle(i).calculateFare(t);
                    break;
                }
            }
        }
        else if(s.equalsIgnoreCase("luxurysedan")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("luxurysedan")){
                    fare = getbookedvehicle(i).calculateFare(t);
                    break;
                }
            }
        }
        else if(s.equalsIgnoreCase("xuv")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("xuv")){
                    fare = getbookedvehicle(i).calculateFare(t);
                    break;
                }
            }
        }
        else if(s.equalsIgnoreCase("electricscooter")){
            for(int i=0; i<bookedvehiclesize(); i++){
                if(getbookedvehicle(i).gettype().equalsIgnoreCase("electricscooter")){
                    fare = getbookedvehicle(i).calculateFare(t);
                    break;
                }
            }
        }
        else{
            System.out.println("Invalid input");
        }
        return fare;
    }
    //returns the total no of vehicles in the fleet rn (not in use)
    public int vehiclesize(){
      return vehicles.size();
    }
    //returns total no of vehicles currently in use rn
    public int bookedvehiclesize(){
        return bookedvehicles.size();
    }
    //used to pick an element of the vehicles list safely in loop traversing in above layers
    public vehicle getvehicle(int i){
        return vehicles.get(i);
    }
    //used to pick an element of the bookedvehicles list safely in loop traversing in above layers
    public vehicle getbookedvehicle(int i){
        return bookedvehicles.get(i);
    }
    public void displayvehicle(){
        System.out.println("List of vehicles available: ");
        for(vehicle v : vehicles){
            System.out.println(v);
        }
    }
}
