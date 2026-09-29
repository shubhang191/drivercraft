package org.example.database;

import org.example.core.Vehicle;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SystemDb {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Vehicle> bookedVehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public boolean removeVehicleByRegNo(int regNo) {
        return vehicles.removeIf(v -> v.getRegNo() == regNo);
    }

    public Vehicle getAvailableVehicleByType(String type) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getType().equalsIgnoreCase(type)) {
                return vehicles.remove(i);
            }
        }
        return null;
    }

    public void addBookedVehicle(Vehicle v) {
        bookedVehicles.add(v);
    }

    public int getAvailableCountByType(String type) {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }

    public List<Vehicle> getAllAvailableVehicles() {
        return vehicles;
    }
}