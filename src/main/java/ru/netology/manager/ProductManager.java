package ru.netology.manager;


import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;

import java.util.Objects;


public class ProductManager {
    private ProductRepository repository;
    private Book book = new Book();
    private SmartPhone smartPhone = new SmartPhone();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;

    }

    public void add(Product product){
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof SmartPhone) {
            SmartPhone smartphone = (SmartPhone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductManager that = (ProductManager) o;
        return Objects.equals(repository, that.repository) && Objects.equals(book, that.book) && Objects.equals(smartPhone, that.smartPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository, book, smartPhone);
    }
}