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

  public ArrayList<OrderTicket> getAllOrdersByEmployeeAndOriginOfficeId(int employee_id, int origin_office_id) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployeeAndOfficeId(employee_id, origin_office_id);
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployeeAndDate(int employee_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployeeAndDate(employee_id, date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByEmployeeAndOriginOfficeIdAndDate(int employee_id, int origin_office_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByEmployeeAndOfficeIdAndDate(employee_id, origin_office_id, date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByDealer(Optional<Employee> employee) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByAssigned_employee(employee);
  }

  public ArrayList<OrderTicket> getAllOrdersByDealerAndOfficeId(int employee_id, int office_id) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByDealerAndOfficeId(employee_id, office_id);
  }

  public ArrayList<OrderTicket> getAllOrdersByDealerAndDate(int employee_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByDealerAndDate(employee_id, date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByDealerAndOfficeIdAndDate(int employee_id, int office_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByDealerAndOfficeIdAndDate(employee_id, office_id, date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByOffice(Optional<Office> office) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOffice(office);
  }

  public ArrayList<OrderTicket> getAllOrdersByOfficeAndOriginOfficeId(int office_id, int origin_office_id) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOfficeAndOriginOfficeId(office_id, origin_office_id);
  }

  public ArrayList<OrderTicket> getAllOrdersByOfficeAndDate(int office_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOfficeAndDate(office_id, date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByOfficeAndOriginOfficeIdAndDate(int office_id, int origin_office_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findByOfficeAndOriginOfficeIdAndDate(office_id, origin_office_id, date_from, date_to);
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

  public ArrayList<OrderTicket> getAllOrdersByTicketStatus(int ticket_status_id) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAllByTicketStatusId(ticket_status_id);
  }

  public ArrayList<OrderTicket> getAllOrdersByDate(String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAllByDate(date_from, date_to);
  }

  public ArrayList<OrderTicket> getAllOrdersByTicketStatusAndDate(int ticket_status_id, String date_from, String date_to) {
    return (ArrayList<OrderTicket>) iOrderTicketRepository.findAllByTicketStatusIdAndDate(ticket_status_id, date_from, date_to);
  }
}
