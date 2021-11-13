package com.supermamilogisticaservice.dtos;

public class TicketStatusByOfficeDto {
  private String office_name;
  private String status;
  private long total;

  public TicketStatusByOfficeDto(String office_name, String status, long total) {
    this.office_name = office_name;
    this.status = status;
    this.total = total;
  }

  public String getOffice_name() {
    return office_name;
  }

  public void setOffice_name(String office_name) {
    this.office_name = office_name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
