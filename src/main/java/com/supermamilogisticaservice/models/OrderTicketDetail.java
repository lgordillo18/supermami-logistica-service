package com.supermamilogisticaservice.models;

import javax.persistence.*;

@Entity(name = "OrderTicketDetail")
@Table(name = "\"DetallePedidos\"", schema = "public")
public class OrderTicketDetail {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
