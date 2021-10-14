package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}