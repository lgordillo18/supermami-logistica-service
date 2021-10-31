package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.OrderTicketDto;
import com.supermamilogisticaservice.dtos.RolDto;
import com.supermamilogisticaservice.dtos.StatusDto;
import com.supermamilogisticaservice.dtos.TicketStatusDto;
import com.supermamilogisticaservice.models.*;
import com.supermamilogisticaservice.services.EmployeeService;
import com.supermamilogisticaservice.services.OfficeService;
import com.supermamilogisticaservice.services.OrderTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/logistica-service")
public class OrderTicketController {

  @Autowired
  private OrderTicketService orderTicketService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private OfficeService officeService;

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

        OrderTicketDto newOrderTicket = new OrderTicketDto(
                ticket.getId(),
                ticket.getOffice().getName(),
                ticket.getDate(),
                ticket.getTicket_status().getName(),
                ticket.getEmployee().getFirst_name());
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
          List<TicketStatusDto> status = new ArrayList<>();
          Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrdersByEmployee(employee);
          for (OrderTicket ticket: arrayTickets) {
            if (ticket.getTicket_status().getName().equals("Aprobado"))
              return orderTicketService.getOrderTicket(employee_id)
                      .map(statusTicket -> new ResponseEntity<>(statusTicket, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

            if (ticket.getTicket_status().getName().equals("Pendiente"))
              return orderTicketService.getOrderTicket(employee_id)
                      .map(statusTicket -> new ResponseEntity<>(statusTicket, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

            if (ticket.getTicket_status().getName().equals("Rechazado"))
              return orderTicketService.getOrderTicket(employee_id)
                      .map(statusTicket -> new ResponseEntity<>(statusTicket, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

            OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(),
                    ticket.getOffice().getName(),
                    ticket.getDate(),
                    ticket.getTicket_status().getName(),
                    ticket.getEmployee().getFirst_name());
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


  //Endpoint de tickets filtrados por sucursal
  @GetMapping("/order-ticket/{office_id}")
  public ResponseEntity getAllOrderTicketsByOffice(@PathVariable("office_id") int office_id) {
    ArrayList<OrderTicketDto> order_tickets = new ArrayList<OrderTicketDto>();

    try {
      Optional<Office> office = officeService.getOffice(office_id);
      if (office.isPresent()) {
        try {
          Iterable<OrderTicket> tickets = orderTicketService.getAllOrdersByOffice(office);
          for (OrderTicket ticket: tickets) {
            OrderTicketDto newOrderTicket = new OrderTicketDto(
                    ticket.getId(),
                    ticket.getOffice().getName(),
                    ticket.getDate(),
                    ticket.getTicket_status().getName(),
                    ticket.getEmployee().getFirst_name());
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
      return new ResponseEntity<>("Office not found", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/order-tickets/status")
  public ResponseEntity getAllTicketStatus() {
    ArrayList<TicketStatusDto> status = new ArrayList<>();
    try {
      Iterable<TicketStatus> arrayStatus = orderTicketService.getAllTicketStatus();
      for (TicketStatus ticketStatus: arrayStatus) {
        TicketStatusDto newTicketStatusDto = new TicketStatusDto(
                ticketStatus.getId(),
                ticketStatus.getName());
        status.add(newTicketStatusDto);
      }
      return new ResponseEntity<>(status, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }
}
