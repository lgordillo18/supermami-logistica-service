package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}