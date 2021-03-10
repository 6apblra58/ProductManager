package ru.netology.domain;

import java.util.Objects;

public class SmartPhone extends Product {
  private String manufacturer;

  public SmartPhone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }

  public String getAuthor() {
    return manufacturer;
  }

  public void setAuthor(String author) {
    this.manufacturer = author;


  }
}
