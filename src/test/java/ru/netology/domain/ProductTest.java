package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Book book = new Book();
    private SmartPhone smartPhone = new SmartPhone();
    private ProductRepository repository = new ProductRepository();

  @Test
  public void shouldUseEqualsProducts() {
    Product first = new Product(1, "Java I", 1000);
    Product second = new Product(1, "Java I", 1000);
    assertEquals(first, second);
  }
  @Test
  public void removeById(){
      Product book = new Product(1,"Java", 1000);
      Product smartPhone = new Product(2, "Huawei",15000);
      repository.save(book);
      repository.save(smartPhone);
      repository.findAll();
      repository.removeById(1);
      Product[] expected = new Product[]{smartPhone};
      Product[] actual = repository.findAll();
      assertArrayEquals(expected, actual);
  }

}
