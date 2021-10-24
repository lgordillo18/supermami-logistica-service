package com.supermamilogisticaservice.dtos;

public class VehicleDto {

  private int id;
  private String patent;
  private String vehicle_brand;
  private String vehicle_model;

  public VehicleDto(int id, String patent, String vehicle_brand, String vehicle_model) {
    this.id = id;
    this.patent = patent;
    this.vehicle_brand = vehicle_brand;
    this.vehicle_model = vehicle_model;
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

  public String getVehicle_brand() {
    return vehicle_brand;
  }

  public void setVehicle_brand(String vehicle_brand) {
    this.vehicle_brand = vehicle_brand;
  }

  public String getVehicle_model() {
    return vehicle_model;
  }

  public void setVehicle_model(String vehicle_model) {
    this.vehicle_model = vehicle_model;
  }
}
