package com.supermamilogisticaservice.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.repository.cdi.Eager;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "User")
@Table(name = "\"Usuarios\"", schema = "public")
@Data
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_user_employee"))
public class User extends Employee implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "fk_employee_rol", value = ConstraintMode.CONSTRAINT))
    private Collection<Rol> rol = new ArrayList<>();

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    public User(String username, String password, Collection<Rol> rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public User() {

    }

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

    public Collection<Rol> getRol() {
        return rol;
    }

    public void setRol(Collection<Rol> rol) {
        this.rol = rol;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
