package ru.netology.domain;

import lombok.Data;

@Data

public class SmartPhone extends Product {
  private String manufacturer;

  public SmartPhone(){
    super();
  }

  public SmartPhone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }
}
