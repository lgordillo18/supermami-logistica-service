package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.VehicleStatus;

public class VehicleCompleteDto {
  private int id;
  private String patent;
  private String vehicleBrand;
  private String vehicleModel;
  private int year;
  private int kg;
  private int id_status;

  public VehicleCompleteDto(int id, String patent, String vehicleBrand, String vehicleModel, int year, int kg, VehicleStatus vehicleStatus) {
    this.id = id;
    this.patent = patent;
    this.vehicleBrand = vehicleBrand;
    this.vehicleModel = vehicleModel;
    this.year = year;
    this.kg = kg;
    this.id_status = vehicleStatus.getId();
    }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPatent() {
    return patent;
  }

  public void setPatent(String patent) {
    this.patent = patent;
  }

  public String getVehicleBrand() {
    return vehicleBrand;
  }

  public void setVehicleBrand(String vehicleBrand) {
    this.vehicleBrand = vehicleBrand;
  }

  public String getVehicleModel() {
    return vehicleModel;
  }

  public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getKg() {
    return kg;
  }

  public void setKg(int kg) {
    this.kg = kg;
  }

  public int getId_status() {
    return id_status;
  }

  public void setId_status(int id_status) {
    this.id_status = id_status;
  }

}

