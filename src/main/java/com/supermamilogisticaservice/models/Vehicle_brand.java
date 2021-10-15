package com.supermamilogisticaservice.models;


import javax.persistence.*;
import java.util.List;


@Entity(name = "Vehicle_brand")
@Table(name = "\"Marca_vehiculos\"", schema = "public")

public class Vehicle_brand {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @OneToMany(mappedBy = "vehicle_brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
