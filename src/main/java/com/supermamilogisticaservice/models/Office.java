package com.supermamilogisticaservice.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.criterion.Order;

import javax.persistence.*; // Hibernate
import java.util.List;

@Entity(name = "Office") // Siempre en ingles y en singular
@Table(name = "\"Sucursales\"", schema = "public") // Siempre en español y en plural
@SQLDelete(sql = "UPDATE \"Sucursales\" SET deleted=true WHERE id = ?") // Para permitir el borrado logico
@Where(clause = "deleted = false")
public class Office {

    @Id // Identifica que es el PK
    @Column(name = "id") // nombre de la columna y debe ser en español
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Seria el autogenerate y incremental
    private int id; // Es una propiedad y tiene que ir en ingles

    @Column(name = "nombre", nullable = false) // nombre de la columna y debe ser en español
    private String name; // Es una propiedad y tiene que ir en ingles

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true) // mappedBy: Hace referencia a la propiedad de la clase Employee
    private List<Employee> employees;

    @Column(name = "deleted")
    private Boolean deleted = false; // Todas las tablas que permitan borrado logico deben tener esta propiedad

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}