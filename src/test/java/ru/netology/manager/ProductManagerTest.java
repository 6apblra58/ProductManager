package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

    class ProductManagerTest {
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
        void searchByAuthor() {
            setUp();

            Product[] search = new Product[]{third};
            Product[] result = manager.searchBy("Sapkowski");
            assertArrayEquals(search, result);
    }
    @Test
        void searchByNameSmartPhone() {
            setUp();

            Product[] search = new Product[]{fifth};
            Product[] result = manager.searchBy("IphoneXR");
            assertArrayEquals(search, result);
    }

    @Test
        void searchByNameBook(){
        setUp();

        Product[] search = new Product[]{second};
        Product[] result = manager.searchBy("GameOfThrones");
        assertArrayEquals(search, result);
    }
    @Test
        void searchNonExistentProduct() {
        setUp();

        Product[] search = new Product[]{};
        Product[] result = manager.searchBy("Samsung");
        assertArrayEquals(search, result);
    }
    @Test
        void searchByManufacturer() {
        setUp();

        Product[] search = new Product[]{fourth, fifth};
        Product[] result = manager.searchBy("Apple");
        assertArrayEquals(search, result);
    }
    @Test
        void searchByName(){
        setUp();

        Product[] search = new Product[]{first};
        Product[] result = manager.searchBy("LordOfTheRings");
        assertArrayEquals(search,result);
    }
}
