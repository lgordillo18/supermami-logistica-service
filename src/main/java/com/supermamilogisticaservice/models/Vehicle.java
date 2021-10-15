package com.supermamilogisticaservice.models;




import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "Vehicle")
@Table(name = "\"Vehiculos\"", schema = "public")

public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patente", nullable = false)
    private String patent;

    @ManyToOne()
    @JoinColumn(name = "id_marca", foreignKey = @ForeignKey(name = "fk_employee_Vehicle_brand", value = ConstraintMode.CONSTRAINT))
    private Vehicle_brand vehicle_brand;

    @ManyToOne()
    @JoinColumn(name = "id_modelo", foreignKey = @ForeignKey(name = "fk_employee_Vehicle_model", value = ConstraintMode.CONSTRAINT))
    private Vehicle_model vehicle_model;

    @Column(name = "año")
    private int year;

    @Column(name = "Kg", nullable = false)
    private int kg;

    @ManyToOne()
    @JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "fk_employee_Vehicle_status", value = ConstraintMode.CONSTRAINT))
    private Vehicle_status vehicle_status;

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

    public Vehicle_brand getVehicle_brand() {
        return vehicle_brand;
    }

    public void setVehicle_brand(Vehicle_brand vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }

    public Vehicle_model getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(Vehicle_model vehicle_model) {
        this.vehicle_model = vehicle_model;
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

    public Vehicle_status getVehicle_status() {
        return vehicle_status;
    }

    public void setVehicle_status(Vehicle_status vehicle_status) {
        this.vehicle_status = vehicle_status;
    }
}
