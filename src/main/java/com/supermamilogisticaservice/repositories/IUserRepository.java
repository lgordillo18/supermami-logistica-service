package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
  List<User> findByRol(Optional<Rol> rol);

  @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
  Optional<User> findByUsernameAndPassword(String username, String password);
}