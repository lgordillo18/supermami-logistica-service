package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.VehicleDto;
import com.supermamilogisticaservice.models.Vehicle;
import com.supermamilogisticaservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<VehicleDto>> getAllVehicles() {
        ArrayList<VehicleDto> vehicles = new ArrayList<VehicleDto>();
        try {
            Iterable<Vehicle> arrayVehicles = vehicleService.getAllVehicles();
            for (Vehicle vehicle: arrayVehicles) {
                VehicleDto newVehicleDto = new VehicleDto(vehicle.getId(), vehicle.getPatent(), vehicle.getVehicle_brand().getName(), vehicle.getVehicle_model().getName());
                vehicles.add(newVehicleDto);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
        catch ( Exception e ) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
