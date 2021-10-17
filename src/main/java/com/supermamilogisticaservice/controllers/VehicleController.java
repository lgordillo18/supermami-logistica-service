package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.Vehicle;
import com.supermamilogisticaservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/logistica-service")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@Validated @RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/vehicles")
    public ArrayList<Vehicle> getAllVehicles(){return vehicleService.getAllVehicles(); }
}
