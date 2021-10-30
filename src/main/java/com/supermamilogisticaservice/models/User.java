package com.supermamilogisticaservice.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "\"Usuarios\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_user_employee"))
public class User extends Employee implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne()
    @JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "fk_employee_rol", value = ConstraintMode.CONSTRAINT))
    private Rol rol;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
