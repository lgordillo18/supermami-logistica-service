package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.*;
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

  @GetMapping("/order-ticket/{id}")
  public ResponseEntity getOrderTicket(@PathVariable("id") int id) {
    try {
      Optional<OrderTicket> orderTicketData = orderTicketService.getOrderTicket(id);
      if (orderTicketData.isPresent()) {
        OrderTicketFullDetailDto order_ticket = new OrderTicketFullDetailDto(orderTicketData.get().getId(), orderTicketData.get().getDate().toString(), orderTicketData.get().getEmployee().getFirst_name(), orderTicketData.get().getEmployee().getLast_name(), orderTicketData.get().getOffice().getName(), orderTicketData.get().getTicket_status(), orderTicketData.get().getOrder_ticket_details());
        return new ResponseEntity<>(order_ticket, HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch ( Exception e ) {
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
                ticket.getEmployee().getFirst_name(),
                ticket.getEmployee().getLast_name(),
                ticket.getOrigin_office().getName()
        );
        order_tickets.add(newOrderTicket);
      }
      return new ResponseEntity<>(order_tickets, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  // Orden de pedido con filtro de Empleado
  @GetMapping("/order-tickets-by-employee/{employee_id}")
  public ResponseEntity getAllOrderTicketsByEmployee(@PathVariable("employee_id") int employee_id) {
    try {
      Optional<Employee> employee = employeeService.getEmployee(employee_id);

      if (employee.isPresent()) {
        try {
          ArrayList<OrderTicketDto> pendingTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> approvedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> rejectedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> deliveredTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> cancelledTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> withOutCategory = new ArrayList<OrderTicketDto>();

          Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrdersByEmployee(employee);
          for (OrderTicket ticket: arrayTickets) {
            OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(), ticket.getOffice().getName(), ticket.getDate(), ticket.getTicket_status().getName(), ticket.getEmployee().getFirst_name(), ticket.getEmployee().getLast_name(), ticket.getOrigin_office().getName());

            // Pendiente (1)
            if (ticket.getTicket_status().getId() == 1) {
              pendingTickets.add(newOrderTicket);
            }
            // Aprobado (2)
            else if (ticket.getTicket_status().getId() == 2) {
              approvedTickets.add(newOrderTicket);
            }
            // Rechazado (3)
            else if (ticket.getTicket_status().getId() == 3) {
              rejectedTickets.add(newOrderTicket);
            }
            else {
              withOutCategory.add(newOrderTicket);
            }
          }

          OrderTicketFullDto order_tickets = new OrderTicketFullDto(pendingTickets, approvedTickets, rejectedTickets, deliveredTickets, cancelledTickets, withOutCategory);
          return new ResponseEntity<>(order_tickets, HttpStatus.OK);
        }
        catch ( Exception e ) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
      } else {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
      }
    } catch ( Exception e ) {
      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
  }

  // Orden de pedido con filtro de Repartidor
  @GetMapping("/order-tickets-by-dealer/{dealer_id}")
  public ResponseEntity getAllOrderTicketsByDealer(@PathVariable("dealer_id") int dealer_id) {
    try {
      Optional<Employee> employee = employeeService.getEmployee(dealer_id);

      if (employee.isPresent()) {
        try {
          ArrayList<OrderTicketDto> pendingTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> rejectedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> approvedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> deliveredTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> cancelledTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> withOutCategory = new ArrayList<OrderTicketDto>();

          Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrdersByDealer(employee);
          for (OrderTicket ticket: arrayTickets) {
            OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(), ticket.getOffice().getName(), ticket.getDate(), ticket.getTicket_status().getName(), ticket.getEmployee().getFirst_name(), ticket.getEmployee().getLast_name(), ticket.getOrigin_office().getName());

            // Aprobado (2)
            if (ticket.getTicket_status().getId() == 2) {
              approvedTickets.add(newOrderTicket);
            }
            // Entregado (4)
            else if (ticket.getTicket_status().getId() == 4) {
              deliveredTickets.add(newOrderTicket);
            }
            // Cancelado (5)
            else if (ticket.getTicket_status().getId() == 5) {
              cancelledTickets.add(newOrderTicket);
            }
            else {
              withOutCategory.add(newOrderTicket);
            }
          }

          OrderTicketFullDto order_tickets = new OrderTicketFullDto(pendingTickets, approvedTickets, rejectedTickets, deliveredTickets, cancelledTickets, withOutCategory);
          return new ResponseEntity<>(order_tickets, HttpStatus.OK);
        }
        catch ( Exception e ) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
      } else {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
      }
    } catch ( Exception e ) {
      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
  }

  //Endpoint de tickets filtrados por sucursal ( PARA ROL ENCARGADO )
  @GetMapping("/order-tickets-by-office/{office_id}")
  public ResponseEntity getAllOrderTicketsByOffice(@PathVariable("office_id") int office_id) {
    try {
      Optional<Office> office = officeService.getOffice(office_id);
      if (office.isPresent()) {
        try {
          ArrayList<OrderTicketDto> pendingTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> approvedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> rejectedTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> deliveredTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> cancelledTickets = new ArrayList<OrderTicketDto>();
          ArrayList<OrderTicketDto> withOutCategory = new ArrayList<OrderTicketDto>();

          Iterable<OrderTicket> arrayTickets = orderTicketService.getAllOrdersByOffice(office);

          for (OrderTicket ticket: arrayTickets) {
            OrderTicketDto newOrderTicket = new OrderTicketDto(ticket.getId(), ticket.getOffice().getName(), ticket.getDate(), ticket.getTicket_status().getName(), ticket.getEmployee().getFirst_name(), ticket.getEmployee().getLast_name(), ticket.getOrigin_office().getName());

            // Pendiente (1)
            if (ticket.getTicket_status().getId() == 1) {
              pendingTickets.add(newOrderTicket);
            }
            // Aprobado (2)
            else if (ticket.getTicket_status().getId() == 2) {
              approvedTickets.add(newOrderTicket);
            }
            // Rechazado (3)
            else if (ticket.getTicket_status().getId() == 3) {
              rejectedTickets.add(newOrderTicket);
            }
            // Entregado (4)
            else if (ticket.getTicket_status().getId() == 4) {
              deliveredTickets.add(newOrderTicket);
            }
            // Entregado (5)
            else if (ticket.getTicket_status().getId() == 5) {
              cancelledTickets.add(newOrderTicket);
            }
            // Cancelado
            else {
              withOutCategory.add(newOrderTicket);
            }
          }

          OrderTicketFullDto order_tickets = new OrderTicketFullDto(pendingTickets, approvedTickets, rejectedTickets, deliveredTickets, cancelledTickets, withOutCategory);
          return new ResponseEntity<>(order_tickets, HttpStatus.OK);
        }
        catch ( Exception e ) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
      } else {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
      }
    } catch ( Exception e ) {
      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
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

  // Endpoint para marcar si un ticket fue entregado, rechazado, cancelado o aprobado
  @PutMapping("/order-ticket/{id}")
  public ResponseEntity modifyOrderTicket(@PathVariable("id") int id, @RequestBody OrderTicketModifyDto order_ticket_modify) {
    try {
      OrderTicket orderTicket = orderTicketService.getOneOrderTicket(id);

      orderTicket.setTicket_status(order_ticket_modify.getTicket_status());
      if (order_ticket_modify.getAssigned_employee() != null) {
        orderTicket.setAssigned_employee(order_ticket_modify.getAssigned_employee());
      }
      if (order_ticket_modify.getCancelled_reason() != null) {
        orderTicket.setCancelled_reason(order_ticket_modify.getCancelled_reason());
      }
      if (order_ticket_modify.getRejected_reason() != null) {
        orderTicket.setRejected_reason(order_ticket_modify.getRejected_reason());
      }

      orderTicketService.saveOrder(orderTicket);
      return new ResponseEntity<>(order_ticket_modify, HttpStatus.OK);
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @GetMapping("/order-ticket/rejected-reasons")
  public ResponseEntity getAllRejectedReasons() {
    try {
      ArrayList<RejectedReason> rejectedReasons = orderTicketService.getAllRejectedReasons();
      return new ResponseEntity<>(rejectedReasons, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @GetMapping("/order-ticket/cancelled-reasons")
  public ResponseEntity getAllCancelledReasons() {
    try {
      ArrayList<CancelledReason> cancelledReasons = orderTicketService.getAllCancelledReasons();
      return new ResponseEntity<>(cancelledReasons, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @DeleteMapping("/order-ticket/{id}")
  public void deleteOrderTicket(@PathVariable int id) {
    orderTicketService.deleteOrder(id);
  }
}
