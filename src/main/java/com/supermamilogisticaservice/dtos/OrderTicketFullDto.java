package com.supermamilogisticaservice.dtos;

import java.util.ArrayList;

public class OrderTicketFullDto {
  private ArrayList<OrderTicketDto> pendingTickets;
  private ArrayList<OrderTicketDto> approvedTickets;
  private ArrayList<OrderTicketDto> rejectedTickets;
  private ArrayList<OrderTicketDto> deliveredTickets;
  private ArrayList<OrderTicketDto> cancelledTickets;

  public OrderTicketFullDto(ArrayList<OrderTicketDto> pendingTickets, ArrayList<OrderTicketDto> approvedTickets, ArrayList<OrderTicketDto> rejectedTickets, ArrayList<OrderTicketDto> deliveredTickets, ArrayList<OrderTicketDto> cancelledTickets) {
    this.pendingTickets = pendingTickets;
    this.approvedTickets = approvedTickets;
    this.rejectedTickets = rejectedTickets;
    this.deliveredTickets = deliveredTickets;
    this.cancelledTickets = cancelledTickets;
  }

  public ArrayList<OrderTicketDto> getPendingTickets() {
    return pendingTickets;
  }

  public void setPendingTickets(ArrayList<OrderTicketDto> pendingTickets) {
    this.pendingTickets = pendingTickets;
  }

  public ArrayList<OrderTicketDto> getApprovedTickets() {
    return approvedTickets;
  }

  public void setApprovedTickets(ArrayList<OrderTicketDto> approvedTickets) {
    this.approvedTickets = approvedTickets;
  }

  public ArrayList<OrderTicketDto> getRejectedTickets() {
    return rejectedTickets;
  }

  public void setRejectedTickets(ArrayList<OrderTicketDto> rejectedTickets) {
    this.rejectedTickets = rejectedTickets;
  }

  public ArrayList<OrderTicketDto> getDeliveredTickets() {
    return deliveredTickets;
  }

  public void setDeliveredTickets(ArrayList<OrderTicketDto> deliveredTickets) {
    this.deliveredTickets = deliveredTickets;
  }

  public ArrayList<OrderTicketDto> getCancelledTickets() {
    return cancelledTickets;
  }

  public void setCancelledTickets(ArrayList<OrderTicketDto> cancelledTickets) {
    this.cancelledTickets = cancelledTickets;
  }
}
