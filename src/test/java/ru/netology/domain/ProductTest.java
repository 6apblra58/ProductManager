package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

  @Test
  public void shouldUseEqualsProducts() {
    Product first = new Product(1, "Java I", 1000);
    Product second = new Product(1, "Java I", 1000);
    assertEquals(first, second);
  }
}
