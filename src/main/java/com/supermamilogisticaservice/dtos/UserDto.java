package com.supermamilogisticaservice.dtos;

public class UserDto {
  private int id;
  private String first_name;
  private String last_name;
  private String full_name;
  private String rol;
  private String username;
  private boolean deleted;

  public UserDto(int id, String first_name, String last_name, String rol, String username, boolean deleted) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.full_name = first_name + " " + last_name;
    this.rol = rol;
    this.username = username;
    this.deleted = deleted;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
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

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
