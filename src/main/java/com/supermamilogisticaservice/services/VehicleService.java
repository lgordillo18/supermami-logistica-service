package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.VehicleStatus;
import com.supermamilogisticaservice.models.Vehicle;
import com.supermamilogisticaservice.repositories.IStatusRepository;
import com.supermamilogisticaservice.repositories.IVehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehicleService {
  @Autowired
  private IVehicleRepository iVehicleRepository;
  @Autowired
  private IStatusRepository iStatusRepository;

  public Vehicle saveVehicle(Vehicle vehicle) {
    return iVehicleRepository.save(vehicle);
  }

  public ArrayList<Vehicle> getAllVehicles(){
    return (ArrayList<Vehicle>) iVehicleRepository.findAll();
  }

  public ArrayList<VehicleStatus> getAllStatus(){
    return (ArrayList<VehicleStatus>) iStatusRepository.findAll();
  }

  public Optional<Vehicle> getVehicle (Integer id){
    return iVehicleRepository.findById(id);
  }

  public void deleteVehicle (int id) {
    iVehicleRepository.deleteById(id);
  }
}
