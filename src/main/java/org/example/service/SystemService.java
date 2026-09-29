package org.example.service;

import org.example.core.Vehicle;
import org.example.repository.SystemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemService {
    private final SystemRepository repository;

    public SystemService(SystemRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(Vehicle v) {
        repository.save(v);
        System.out.println("Successfully added to the fleet!");
    }

    public void removeVehicle(int regNo) {
        if (repository.deleteByRegNo(regNo)) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle with RegNo " + regNo + " not found or is currently booked.");
        }
    }

    public void displayAvailableVehicles() {
        List<Vehicle> available = repository.findAllAvailable();
        if (available.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("\n--- Available Fleet ---");
            available.forEach(System.out::println);
            System.out.println("-----------------------");
        }
    }

    public void assignAvailableCar(String type, int timeHours) {
        if (repository.getAvailableCount(type) > 0) {
            Vehicle assignedVehicle = repository.bookVehicle(type);
            if (assignedVehicle != null) {
                System.out.println("Vehicle Assigned: " + assignedVehicle.toString());
                System.out.println("Total Fare: Rs " + assignedVehicle.calculateFare(timeHours));
            }
        } else {
            System.out.println("No vehicles of type " + type + " are currently available.");
        }
    }
}