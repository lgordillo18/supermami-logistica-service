package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.dtos.TicketStatusDto;
import com.supermamilogisticaservice.models.*;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import com.supermamilogisticaservice.repositories.ITicketStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderTicketService {
  @Autowired
  private IOrderTicketRepository iOrderTicketRepository;
  @Autowired
  private ITicketStatusRepository iTicketStatusRepository;

  public OrderTicket saveOrder(OrderTicket orderTicket) {
    return iOrderTicketRepository.save(orderTicket);
  }

  public ArrayList<OrderTicket> getAllOrders() {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAll();
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployee(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployee(employee);
  }
  //TODO: crear endpoint ticket por sucursal
  public ArrayList<OrderTicket> getAllOrdersByOffice(Optional<Office> office) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOffice(office);
  }

  public Optional<OrderTicket> getOrderTicket (Integer id){
    return iOrderTicketRepository.findById(id);
  }

  public ArrayList<TicketStatus> getAllTicketStatus(){
    return (ArrayList<TicketStatus>) iTicketStatusRepository.findAll();

  }
}
