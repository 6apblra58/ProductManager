package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmartPhoneTest {
    private ProductRepository repository = new ProductRepository();
    private SmartPhone Iphone = new SmartPhone();

    @Test
    public void shouldSaveOneItem(){
        repository.save(Iphone);

        Product[] expected = new Product[]{Iphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }
}
