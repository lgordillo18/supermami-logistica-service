package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.Employee;

import java.util.Date;

public class OrderTicketDto {
  private int ticket_number;
  private String origin_office;
  private String office;
  private java.util.Date date;
  private String status;
  private String employee_name;

  public OrderTicketDto(int ticket_number, String office, Date date, String status, String employee_first_name, String employee_last_name, String origin_office) {
    this.ticket_number = ticket_number;
    this.office = office;
    this.date = date;
    this.status = status;
    this.employee_name = employee_first_name + " " + employee_last_name;
    this.origin_office = origin_office;
  }

  public int getTicket_number() {
    return ticket_number;
  }

  public void setTicket_number(int ticket_number) {
    this.ticket_number = ticket_number;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getEmployee_name() {
    return employee_name;
  }

  public void setEmployee_name(String employee_name) {
    this.employee_name = employee_name;
  }

  public String getOrigin_office() {
    return origin_office;
  }

  public void setOrigin_office(String origin_office) {
    this.origin_office = origin_office;
  }
}
