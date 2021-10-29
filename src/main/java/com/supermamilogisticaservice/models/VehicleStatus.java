package com.supermamilogisticaservice.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "VehicleStatus")
@Table(name = "\"EstadoVehiculos\"", schema = "public")

public class VehicleStatus {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @OneToMany(mappedBy = "vehicleStatus", cascade = CascadeType.ALL, orphanRemoval = true)
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
