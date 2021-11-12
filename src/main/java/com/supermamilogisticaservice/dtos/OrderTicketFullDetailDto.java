package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.OrderTicketDetail;
import com.supermamilogisticaservice.models.TicketStatus;

import java.util.List;
import java.util.Objects;

public class OrderTicketFullDetailDto {
  private int id;
  private String date;
  private String employee_name;
  private String office_name;
  private TicketStatus ticket_status;
  private List<OrderTicketDetail> ticket_details;

  public OrderTicketFullDetailDto(int id, String date, String employee_first_name, String employee_last_name, String office_name, TicketStatus ticket_status, List<OrderTicketDetail> ticket_details) {
    this.id = id;
    this.date = date;
    this.employee_name = employee_first_name + " " + employee_last_name;
    this.office_name = office_name;
    this.ticket_status = ticket_status;
    this.ticket_details = ticket_details;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getEmployee_name() {
    return employee_name;
  }

  public void setEmployee_name(String employee_name) {
    this.employee_name = employee_name;
  }

  public String getOffice_name() {
    return office_name;
  }

  public void setOffice_name(String office_name) {
    this.office_name = office_name;
  }

  public TicketStatus getTicket_status() {
    return ticket_status;
  }

  public void setTicket_status(TicketStatus ticket_status) {
    this.ticket_status = ticket_status;
  }

  public List<OrderTicketDetail> getTicket_details() {
    return ticket_details;
  }

  public void setTicket_details(List<OrderTicketDetail> ticket_details) {
    this.ticket_details = ticket_details;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderTicketFullDetailDto that = (OrderTicketFullDetailDto) o;
    return Objects.equals(ticket_details, that.ticket_details);
  }

  @Override
  public int hashCode() {return Objects.hash(ticket_details);}
}
