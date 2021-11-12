package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.dtos.OrderTicketDto;
import com.supermamilogisticaservice.dtos.OrderTicketFullDetailDto;
import com.supermamilogisticaservice.dtos.OrderTicketFullDto;
import com.supermamilogisticaservice.models.*;
import com.supermamilogisticaservice.repositories.ICancelledReasonRepository;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import com.supermamilogisticaservice.repositories.IRejectedReasonRepository;
import com.supermamilogisticaservice.repositories.ITicketStatusRepository;
import com.supermamilogisticaservice.utils.dateUtils;
import com.supermamilogisticaservice.utils.orderSorterUtils;
import javassist.NotFoundException;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

  public ArrayList<OrderTicket> getAllOrders(){
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAll();
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployee(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployee(employee);
  }

  public ArrayList<OrderTicket> getAllOrdersByDealer(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByAssigned_employee(employee);
  }

  public ArrayList<OrderTicket> getAllOrdersByOffice(Optional<Office> office) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOffice(office);
  }

  public Optional<OrderTicket> getOrderTicket (Integer id){
    return iOrderTicketRepository.findById(id);
  }

  public OrderTicket getOneOrderTicket (Integer id){
    return iOrderTicketRepository.getOne(id);
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

  public void deleteOrder(int id) { iOrderTicketRepository.deleteById(id); }


  public OrderTicket getTicketByIdNumber(Map<String, String> params, String ticketNumber) throws NotFoundException {
    List<OrderTicket> tickets = orderSorterUtils.getSortedList(params, iOrderTicketRepository);
    tickets.sort(new Comparator<OrderTicket>() {
      @Override
      public int compare(OrderTicket o1, OrderTicket o2) {
        return o1.getTicket_status().getName().compareToIgnoreCase(o2.getTicket_status().getName());
      }
    });
    return new OrderTicket();
  }

}
