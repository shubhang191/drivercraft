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
    public void assign_av_car(vehicle v, int t){
        if(r.vehiclesizerepo() != 0){
            for(int i=0; i<r.vehiclesizerepo(); i++){
                if(r.searchtypevehiclesrepo(v)){
                    r.assign(v);
                    System.out.println("Vehicle of type " + v.gettype() + " successfully assigned!..");
                    System.out.println("Base fare: " + v.calculateFare(t));
                }
            }
        }
        else{
            System.out.println("No vehicles available!");
        }
    }
    public void Addvehicle(vehicle v){
        r.save(v);
    }
}
