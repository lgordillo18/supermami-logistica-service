package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}