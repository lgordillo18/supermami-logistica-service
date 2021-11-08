package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.StatusDto;
import com.supermamilogisticaservice.dtos.VehicleCompleteDto;
import com.supermamilogisticaservice.dtos.VehicleDto;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.models.Vehicle;
import com.supermamilogisticaservice.models.VehicleStatus;
import com.supermamilogisticaservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/logistica-service")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

      @PostMapping("/vehicle")
  public ResponseEntity createVehicle(@Validated @RequestBody Vehicle vehicle) {
      try {
        Vehicle newVehicle = vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
      }
  }

  @GetMapping("/vehicles")
  public ResponseEntity getAllVehicles() {
    ArrayList<VehicleDto> vehicles = new ArrayList<VehicleDto>();
    try {
      Iterable<Vehicle> arrayVehicles = vehicleService.getAllVehicles();
      for (Vehicle vehicle: arrayVehicles) {
        VehicleDto newVehicleDto = new VehicleDto(vehicle.getId(), vehicle.getPatent(), vehicle.getVehicleBrand(), vehicle.getVehicleModel(), vehicle.getVehicleStatus().getName(), vehicle.getEmployee().getFirst_name(), vehicle.getEmployee().getLast_name(), vehicle.isDeleted(), vehicle.getEmployee().getOffice().getId());
        vehicles.add(newVehicleDto);
      }
      return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @GetMapping("/vehicle/status")
  public ResponseEntity getAllStatus() {
    ArrayList<StatusDto> status = new ArrayList<StatusDto>();
    try {
      Iterable<VehicleStatus> arrayStatus = vehicleService.getAllStatus();
      for (VehicleStatus vehicleStatus: arrayStatus) {
        StatusDto newStatusDto = new StatusDto(vehicleStatus.getId(), vehicleStatus.getName());
        status.add(newStatusDto);
      }
      return new ResponseEntity<>(status, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }


  @GetMapping(path = "/vehicle/{id}")
  public ResponseEntity getVehicle(@PathVariable("id") int id) {
    try {
      Optional<Vehicle> vehicleData = vehicleService.getVehicle(id);
      if (vehicleData.isPresent()) {
        VehicleCompleteDto newVehicleDto = new VehicleCompleteDto(vehicleData.get().getId(), vehicleData.get().getPatent(), vehicleData.get().getVehicleBrand(), vehicleData.get().getVehicleModel(), vehicleData.get().getYear(), vehicleData.get().getKg(), vehicleData.get().getVehicleStatus());
        return new ResponseEntity<>(newVehicleDto, HttpStatus.OK);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @PutMapping("/vehicle/{id}")
  public Vehicle updateVehicle(@PathVariable String id, @Validated @RequestBody Vehicle vehicle) {
    return vehicleService.saveVehicle(vehicle);
  }

  @PutMapping("/vehicle/delete/{id}")
  public ResponseEntity deleteVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
    try {
      Optional<Vehicle> vehicleData = vehicleService.getVehicle(id);
      if (vehicleData.isPresent()) {
        Vehicle _vehicle = vehicleData.get();
        _vehicle.setDeleted(vehicle.isDeleted());
        vehicleService.saveVehicle(_vehicle);
        return new ResponseEntity<>(vehicleData, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

}
