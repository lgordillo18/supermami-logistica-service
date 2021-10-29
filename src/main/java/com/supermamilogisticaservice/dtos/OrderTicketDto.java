package com.supermamilogisticaservice.dtos;

import java.util.Date;

public class OrderTicketDto {
  private int ticket_number;
  private String office;
  private java.util.Date date;

  public OrderTicketDto(int ticket_number, String office, Date date) {
    this.ticket_number = ticket_number;
    this.office = office;
    this.date = date;
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
}
