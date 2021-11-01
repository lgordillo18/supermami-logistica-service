package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.Employee;

import java.util.Date;

public class OrderTicketDto {
  private int ticket_number;
  private String office;
  private java.util.Date date;
  private String status;
  private String employee;



  public OrderTicketDto(int ticket_number, String office, Date date, String status, String employee) {
    this.ticket_number = ticket_number;
    this.office = office;
    this.date = date;
    this.status = status;
    this.employee = employee;

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

  public String getEmployee() {
    return employee;
  }

  public void setEmployee(String employee) {
    this.employee = employee;
  }
}
