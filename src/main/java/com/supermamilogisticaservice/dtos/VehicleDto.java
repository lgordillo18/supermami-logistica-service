package com.supermamilogisticaservice.dtos;

public class VehicleDto {

  private int id;
  private String patent;
  private String vehicleBrand;
  private String vehicleModel;
  private String vehicleStatus;
  private String employeeFirstName;
  private String employeeLastName;
  private String employeeFullName;
  private boolean deleted;

  public VehicleDto(int id, String patent, String vehicleBrand, String vehicleModel, String vehicleStatus, String employeeFirstName, String employeeLastName, boolean deleted) {
    this.id = id;
    this.patent = patent;
    this.vehicleBrand = vehicleBrand;
    this.vehicleModel = vehicleModel;
    this.vehicleStatus = vehicleStatus;
    this.employeeFullName = employeeFirstName + " " + employeeLastName;
    this.deleted = deleted;
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

  public String getVehicleStatus() {
    return vehicleStatus;
  }

  public void setVehicleStatus(String vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
  }

  public String getEmployeeFirstName() {
    return employeeFirstName;
  }

  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }

  public String getEmployeeLastName() {
    return employeeLastName;
  }

  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }

  public String getEmployeeFullName() {
    return employeeFullName;
  }

  public void setEmployeeFullName(String employeeFullName) {
    this.employeeFullName = employeeFullName;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
