package org.example.service;

import org.example.core.vehicle;
import org.example.repository.systemRepository;
import org.springframework.stereotype.Service;

@Service
public class systemService {
    private final systemRepository r;
    public systemService(systemRepository r){
        this.r = r;
    }

    public void assign_av_car(String s, int t){
        vehicle v;
        if(r.vehiclesizerepo() != 0){
            if(r.getcarbytyperepo(s) != 0){
                r.assign(s);
                System.out.println("Vehicle of type " + s + " successfully assigned!..");
                System.out.println("Base fare: " + r.getfareofvehiclerepo(s, t));
            }
        }
        else{
            System.out.println("No vehicles available!");
        }
    }
    public int getcarbytypeservice(String s){ return r.getcarbytyperepo(s); }
    public int getbookedcarbytypeservice(String s){ return r.getbookedcarbytyperepo(s); }
    public void removevehicle(String s){
        r.remove(s);
    }
    public void Addvehicle(vehicle v){
        r.save(v);
    }
}
