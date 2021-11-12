package com.supermamilogisticaservice.dtos;

public class OrderListByDealerDto {
  private String full_name;
  private String office_name;
  private long total;

  public OrderListByDealerDto(String first_name, String last_name, String office_name, long total) {
    this.full_name = first_name + " " + last_name;
    this.office_name = office_name;
    this.total = total;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getOffice_name() {
    return office_name;
  }

  public void setOffice_name(String office_name) {
    this.office_name = office_name;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
