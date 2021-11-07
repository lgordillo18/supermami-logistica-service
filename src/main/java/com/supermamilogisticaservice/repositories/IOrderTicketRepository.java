package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderTicketRepository extends JpaRepository<OrderTicket, Integer>{
  List<OrderTicket> findByEmployee(Optional<Employee> employee);

  @Query("SELECT o FROM OrderTicket o JOIN Employee e ON e.id = o.assigned_employee.id WHERE o.assigned_employee = ?1")
  List<OrderTicket> findByAssigned_employee(Optional<Employee> assigned_employee);

  //TODO: crear endpoint ticket por sucursal
  List<OrderTicket> findByOffice(Optional<Office> office);
}