package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.Area;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.Rol;

public class UserCompleteDto {
  private int id;
  private String first_name;
  private String last_name;
  private String username;
  private String dni;
  private String phone_number;
  private String email;
  private String address;
  private int id_office;
  private int id_rol;
  private int id_area;
  private String rol_name;

  public UserCompleteDto(int id, String first_name, String last_name, String username, String dni, String phone_number, String email, String address, Office office, Rol rol, Area area, String rol_name) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.username = username;
    this.dni = dni;
    this.phone_number = phone_number;
    this.email = email;
    this.address = address;
    this.id_office = office.getId();
    this.id_rol = rol.getId();
    if (area != null) {
      this.id_area = area.getId();
    }
    this.rol_name = rol_name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getId_office() {
    return id_office;
  }

  public void setId_office(int id_office) {
    this.id_office = id_office;
  }

  public int getId_rol() {
    return id_rol;
  }

  public void setId_rol(int id_rol) {
    this.id_rol = id_rol;
  }

  public int getId_area() {
    return id_area;
  }

  public void setId_area(int id_area) {
    this.id_area = id_area;
  }

  public String getRol_name() {
    return rol_name;
  }

  public void setRol_name(String rol_name) {
    this.rol_name = rol_name;
  }
}
