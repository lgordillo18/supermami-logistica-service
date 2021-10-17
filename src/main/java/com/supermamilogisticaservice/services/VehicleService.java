package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Vehicle;
import com.supermamilogisticaservice.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehicleService {
    @Autowired
    private IVehicleRepository iVehicleRepository;
    public Vehicle saveVehicle(Vehicle vehicle) {
        return iVehicleRepository.save(vehicle);
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return (ArrayList<Vehicle>) iVehicleRepository.findAll();
    }
}

