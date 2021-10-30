package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.OrderTicket;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderTicketService {
  @Autowired
  private IOrderTicketRepository iOrderTicketRepository;

  public OrderTicket saveOrder(OrderTicket orderTicket) {
    return iOrderTicketRepository.save(orderTicket);
  }

  public ArrayList<OrderTicket> getAllOrders() {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAll();
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployee(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployee(employee);
  }

  public Optional<OrderTicket> getOrderTicket (Integer id){
    return iOrderTicketRepository.findById(id);
  }
}
