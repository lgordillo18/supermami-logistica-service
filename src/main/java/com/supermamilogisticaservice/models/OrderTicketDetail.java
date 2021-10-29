package com.supermamilogisticaservice.models;

import javax.persistence.*;

@Entity(name = "OrderTicketDetail")
@Table(name = "\"DetallePedidos\"", schema = "public")
public class OrderTicketDetail {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne()
  @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "fk_detalle_pedido_pedido", value = ConstraintMode.CONSTRAINT))
  private OrderTicket order_ticket;

  @Column(name = "cantidad", nullable = false)
  private long quantity;

  @ManyToOne(optional = false)
  @JoinColumn(name="product_id")
  private Product product;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public OrderTicket getOrder_ticket() {
    return order_ticket;
  }

  public void setOrder_ticket(OrderTicket order_ticket) {
    this.order_ticket = order_ticket;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
