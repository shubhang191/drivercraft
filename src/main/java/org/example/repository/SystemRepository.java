package org.example.repository;

import org.example.core.Vehicle;
import org.example.database.SystemDb;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemRepository {
    private final SystemDb db;

    public SystemRepository(SystemDb db) {
        this.db = db;
    }

    public void save(Vehicle v) {
        db.addVehicle(v);
    }

    public boolean deleteByRegNo(int regNo) {
        return db.removeVehicleByRegNo(regNo);
    }

    public Vehicle bookVehicle(String type) {
        Vehicle v = db.getAvailableVehicleByType(type);
        if (v != null) {
            db.addBookedVehicle(v);
        }
        return v;
    }

    public int getAvailableCount(String type) {
        return db.getAvailableCountByType(type);
    }

    public List<Vehicle> findAllAvailable() {
        return db.getAllAvailableVehicles();
    }
}