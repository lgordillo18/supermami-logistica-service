package com.supermamilogisticaservice.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "OrderTicket")
@Table(name = "\"Pedidos\"", schema = "public")
public class OrderTicket implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;

  @Temporal(TemporalType.DATE)
  @Column(name = "fecha")
  private java.util.Date date = new Date();

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "pedido_id")
  private List<OrderTicketDetail> order_ticket_details;

  @ManyToOne(optional = false)
  @JoinColumn(name="employee_id")
  private Employee employee;

  @ManyToOne(optional = false)
  @JoinColumn(name="origin_office_id")
  private Office origin_office;

  @ManyToOne(optional = false)
  @JoinColumn(name="office_id")
  private Office office;

  @ManyToOne(optional = false)
  @JoinColumn(name="ticket_status_id")
  private TicketStatus ticket_status;

  @ManyToOne()
  @JoinColumn(name="rejected_reason_id")
  private RejectedReason rejected_reason;

  @ManyToOne()
  @JoinColumn(name="cancelled_reason_id")
  private CancelledReason cancelled_reason;

  @Temporal(TemporalType.DATE)
  @Column(name = "fecha_finalizacion")
  private java.util.Date finish_date = new Date();

  public TicketStatus getTicket_status() {
    return ticket_status;
  }

  public void setTicket_status(TicketStatus ticket_status) {
    this.ticket_status = ticket_status;
  }

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<OrderTicketDetail> getOrder_ticket_details() {
    return order_ticket_details;
  }

  public void setOrder_ticket_details(List<OrderTicketDetail> order_ticket_details) {
    this.order_ticket_details = order_ticket_details;
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

  public Office getOrigin_office() {
    return origin_office;
  }

  public void setOrigin_office(Office origin_office) {
    this.origin_office = origin_office;
  }
}
