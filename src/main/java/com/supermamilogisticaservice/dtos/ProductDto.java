package com.supermamilogisticaservice.dtos;

public class ProductDto {
  private String product_name;
  private long product_quantity;
  private String office_name;

  public ProductDto(String product_code, String product_name, long product_quantity, String office_name) {
    this.product_name = '(' + product_code + ')' + ' ' + product_name;
    this.product_quantity = product_quantity;
    this.office_name = office_name;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public long getProduct_quantity() {
    return product_quantity;
  }

  public void setProduct_quantity(long product_quantity) {
    this.product_quantity = product_quantity;
  }

  public String getOffice_name() {
    return office_name;
  }

  public void setOffice_name(String office_name) {
    this.office_name = office_name;
  }
}
