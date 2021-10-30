package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.OfficeDto;
import com.supermamilogisticaservice.dtos.OrderTicketDto;
import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.OrderTicket;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.EmployeeService;
import com.supermamilogisticaservice.services.OfficeService;
import com.supermamilogisticaservice.services.OrderTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/logistica-service")
public class OrderTicketController {

  @Autowired
  private OrderTicketService orderTicketService;

  @Autowired
  private EmployeeService employeeService;

  @PostMapping("/order-ticket")
  public ResponseEntity createOrderTicket(@Validated @RequestBody OrderTicket orderTicket) {
    try {
      OrderTicket newOrderTicket = orderTicketService.saveOrder(orderTicket);
      return new ResponseEntity<>(newOrderTicket, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  // Orden de pedido sin filtros (para rol admin)
  @GetMapping("/order-tickets")
  public ResponseEntity getAllOrderTickets() {
    ArrayList<OrderTicketDto> order_tickets = new ArrayList<OrderTicketDto>();
    try {
      Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrders();
      for (OrderTicket ticket: arrayTickets) {

        OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(), ticket.getOffice().getName(), ticket.getDate());
        order_tickets.add(newOrderTicket);
      }
      return new ResponseEntity<>(order_tickets, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  // Orden de pedido con filtro de Empleado
  @GetMapping("/order-tickets/{employee_id}")
  public ResponseEntity getAllOrderTicketsByEmployee(@PathVariable("employee_id") int employee_id) {
    ArrayList<OrderTicketDto> order_tickets = new ArrayList<OrderTicketDto>();

    try {
      Optional<Employee> employee = employeeService.getEmployee(employee_id);

      if (employee.isPresent()) {
        try {
          Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrdersByEmployee(employee);
          for (OrderTicket ticket: arrayTickets) {

            OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(), ticket.getOffice().getName(), ticket.getDate());
            order_tickets.add(newOrderTicket);
          }
          return new ResponseEntity<>(order_tickets, HttpStatus.OK);
        }
        catch ( Exception e ) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
      } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
      }
    } catch ( Exception e ) {
      return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }
  }
}
