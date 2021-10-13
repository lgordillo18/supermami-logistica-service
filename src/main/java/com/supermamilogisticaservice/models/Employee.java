package com.supermamilogisticaservice.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Employee")
@Table(name = "\"Empleados\"", schema = "public")
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_employee_person"))
public class Employee extends Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "id_area")
  private int id_area;

  @Column(name = "id_sucursal")
  private int id_office;

  public int getId_area() {
    return id_area;
  }

  public void setId_area(int id_area) {
    this.id_area = id_area;
  }

  public int getId_office() {
    return id_office;
  }

  public void setId_office(int id_office) {
    this.id_office = id_office;
  }
}
