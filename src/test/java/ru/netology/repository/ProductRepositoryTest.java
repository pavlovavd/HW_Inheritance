package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();

        int idToRemove = 1;

        Product first = new Product(1, "first", 100);
        Product second = new Product(2, "second", 200);
        Product third = new Product(3, "third", 300);

        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(idToRemove);

        Product[] expected = new Product[]{second, third};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdOneProduct() {
        ProductRepository repo = new ProductRepository();
        int idToFind = 1;

        Product first = new Product(1, "first", 100);

        repo.save(first);

        repo.findById(idToFind);

        Product[] expected = new Product[]{first};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdTwoProduct() {
        ProductRepository repo = new ProductRepository();

        Product first = new Product(1, "first", 100);
        Product second = new Product(1, "second", 100);

        repo.save(first);
        repo.save(second);

        repo.findById(1);
        repo.findById(2);

        Product[] expected = new Product[]{first, second};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

}