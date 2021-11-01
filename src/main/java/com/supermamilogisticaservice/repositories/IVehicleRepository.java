package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Person;
import com.supermamilogisticaservice.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
}
