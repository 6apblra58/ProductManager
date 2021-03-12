package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private Book book = new Book();
  private SmartPhone smartPhone = new SmartPhone();
  private ProductRepository repository = new ProductRepository();
  private ProductManager manager = new ProductManager(repository);


        Product first = new Book(1,"LordOfTheRings", 2500, "Tolkien");
        Product second = new Book(2,"GameOfThrones", 2500, "Martin");
        Product third = new Book(3, "Witcher", 2500,"Sapkowski");
        Product fourth = new SmartPhone(4,"Iphone12ProMax", 120000,"Apple");
        Product fifth = new SmartPhone(5,"IphoneXR", 60000,"Apple");
        Product sixth = new SmartPhone(6, "Mi11", 60000,"Xiaomi");

        public void setUp () {
            manager.add(first);
            manager.add(second);
            manager.add(third);
            manager.add(fourth);
            manager.add(fifth);
            manager.add(sixth);
        }

  @Test
  public void shouldSaveOneItem() {
    repository.save(book);

    Product[] expected = new Product[]{book};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldSaveAllItems() {
    repository.save(book);
    repository.save(smartPhone);
    Product[] expected = new Product[]{book, smartPhone};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  public void removeById(){
            setUp();
   repository.findAll();
   repository.removeById(1);
   Product[] expected = new Product[]{second,third,fourth,fifth,sixth};
   Product[] actual = repository.findAll();
   assertArrayEquals(expected, actual);


  }
}
