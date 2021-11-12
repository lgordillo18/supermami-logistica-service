package com.supermamilogisticaservice.dtos;

public class ProductListDto {

  private String code;
  private String name;
  private long total;

  public ProductListDto(String code, String name, long total) {
    this.code = code;
    this.name = name;
    this.total = total;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
