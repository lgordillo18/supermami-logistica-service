package com.supermamilogisticaservice.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Employee")
@Table(name = "\"Empleados\"", schema = "public")
// @OnDelete(action = OnDeleteAction.NO_ACTION)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_employee_person"))
public class Employee extends Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @ManyToOne()
  @JoinColumn(name = "id_sucursal", foreignKey = @ForeignKey(name = "fk_employee_sucursal", value = ConstraintMode.CONSTRAINT))
  private Office office;

  @ManyToOne()
  @JoinColumn(name = "id_area", foreignKey = @ForeignKey(name = "fk_employee_area", value = ConstraintMode.CONSTRAINT))
  private Area area;

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }
}
