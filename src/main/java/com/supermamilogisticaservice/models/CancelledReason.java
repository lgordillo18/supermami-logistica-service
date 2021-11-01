package com.supermamilogisticaservice.models;

import javax.persistence.*;

@Entity(name = "CancelledReason")
@Table(name = "\"MotivosDeCancelacion\"", schema = "public")
public class CancelledReason {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "nombre", nullable = false)
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
