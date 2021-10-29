package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
  @Autowired
  private IEmployeeRepository iEmployeeRepository;

  public Optional<Employee> getEmployee (Integer id){
    return iEmployeeRepository.findById(id);
  }
}
