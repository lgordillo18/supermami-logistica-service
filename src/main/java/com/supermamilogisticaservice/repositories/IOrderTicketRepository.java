package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderTicketRepository extends JpaRepository<OrderTicket, Integer>{
  List<OrderTicket> findByEmployee(Optional<Employee> employee);
}