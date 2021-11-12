package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderTicketRepository extends JpaRepository<OrderTicket, Integer>{
  List<OrderTicket> findByEmployee(Optional<Employee> employee);

  @Query("SELECT o FROM OrderTicket o JOIN Employee e ON e.id = o.assigned_employee.id WHERE o.assigned_employee = ?1")
  List<OrderTicket> findByAssigned_employee(Optional<Employee> assigned_employee);

  List<OrderTicket> findByOffice(Optional<Office> office);

  //listado de pendientes ordenados por fecha descendiente

  @Query("SELECT o FROM OrderTicket o " +
          "WHERE o.ticket_status = ?2 " +
          "ORDER BY o.id DESC")
  List<OrderTicket> findTicketByIdDesc(@Param("ticket_status") String ticketNumber);

  @Query("SELECT o FROM OrderTicket o " +
          "WHERE o.ticket_status = ?2 " +
          "ORDER BY o.id ASC")
  List<OrderTicket> findTicketByIdAsc(@Param("ticket_status") String ticketNumber);

}