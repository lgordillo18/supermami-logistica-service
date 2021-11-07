package com.supermamilogisticaservice.dtos;

import com.supermamilogisticaservice.models.CancelledReason;
import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.RejectedReason;
import com.supermamilogisticaservice.models.TicketStatus;

import java.util.Date;

public class OrderTicketModifyDto {
  private Employee employee;
  private TicketStatus ticket_status;
  private RejectedReason rejected_reason;
  private CancelledReason cancelled_reason;
  private java.util.Date finish_date;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public TicketStatus getTicket_status() {
    return ticket_status;
  }

  public void setTicket_status(TicketStatus ticket_status) {
    this.ticket_status = ticket_status;
  }

  public RejectedReason getRejected_reason() {
    return rejected_reason;
  }

  public void setRejected_reason(RejectedReason rejected_reason) {
    this.rejected_reason = rejected_reason;
  }

  public CancelledReason getCancelled_reason() {
    return cancelled_reason;
  }

  public void setCancelled_reason(CancelledReason cancelled_reason) {
    this.cancelled_reason = cancelled_reason;
  }

  public Date getFinish_date() {
    return finish_date;
  }

  public void setFinish_date(Date finish_date) {
    this.finish_date = finish_date;
  }
}
