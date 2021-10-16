package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IUserRepository extends JpaRepository<User, Integer> {

    public abstract ArrayList<Rol> findByRoles(Integer id);
}