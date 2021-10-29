package com.supermamilogisticaservice.models;
import javax.persistence.*;

@Entity(name = "Vehicle")
@Table(name = "\"Vehiculos\"", schema = "public")

public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patente", nullable = false)
    private String patent;

    @Column(name = "vehiculo_marca", nullable = false)
    private String vehicleBrand;

    @Column(name = "vehiculo_modelo", nullable = false)
    private String vehicleModel;

    @Column(name = "año")
    private int year;

    @Column(name = "Kg", nullable = false)
    private int kg;

    @ManyToOne()
    @JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "fk_employee_VehicleStatus", value = ConstraintMode.CONSTRAINT))
    private VehicleStatus vehicleStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

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

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
