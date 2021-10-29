package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}