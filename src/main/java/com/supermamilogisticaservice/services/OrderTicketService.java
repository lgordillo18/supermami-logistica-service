package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.*;
import com.supermamilogisticaservice.repositories.ICancelledReasonRepository;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import com.supermamilogisticaservice.repositories.IRejectedReasonRepository;
import com.supermamilogisticaservice.repositories.ITicketStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderTicketService {
  @Autowired
  private IOrderTicketRepository iOrderTicketRepository;
  @Autowired
  private ITicketStatusRepository iTicketStatusRepository;
  @Autowired
  private ICancelledReasonRepository iCancelledReasonRepository;
  @Autowired
  private IRejectedReasonRepository iRejectedReasonRepository;

  public OrderTicket saveOrder(OrderTicket orderTicket) {
    return iOrderTicketRepository.save(orderTicket);
  }

  public ArrayList<OrderTicket> getAllOrders() {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAll();
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployee(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployee(employee);
  }

  public ArrayList<OrderTicket> getAllOrdersByOffice(Optional<Office> office) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOffice(office);
  }

  public Optional<OrderTicket> getOrderTicket (Integer id){
    return iOrderTicketRepository.findById(id);
  }

  public ArrayList<TicketStatus> getAllTicketStatus(){
    return (ArrayList<TicketStatus>) iTicketStatusRepository.findAll();
  }

  public ArrayList<RejectedReason> getAllRejectedReasons() {
    return (ArrayList<RejectedReason>) iRejectedReasonRepository.findAll();
  }
  public ArrayList<CancelledReason> getAllCancelledReasons() {
    return (ArrayList<CancelledReason>) iCancelledReasonRepository.findAll();
  }
}
