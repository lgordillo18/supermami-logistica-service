package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfficeRepository extends JpaRepository<Office, Integer> {
}
