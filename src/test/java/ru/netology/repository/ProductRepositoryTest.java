package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    public void shouldNotFoundException() {
        ProductRepository repo = new ProductRepository();
        Product first = new Product(1, "first", 100);
        Book Inspector = new Book(2, "Ревизор", 200, "М.Горький");
        Smartphone IPhone = new Smartphone(3, "IPhone", 500, "Apple");

        repo.save(first);
        repo.save(Inspector);
        repo.save(IPhone);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(4));

    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        int idToRemove = 1;
        Product first = new Product(1, "first", 100);
        Book Inspector = new Book(2, "Ревизор", 200, "М.Горький");
        Smartphone IPhone = new Smartphone(3, "IPhone", 500, "Apple");

        repo.save(first);
        repo.save(Inspector);
        repo.save(IPhone);
        repo.removeById(idToRemove);

        Product[] expected = new Product[]{Inspector, IPhone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneItem() {
        ProductRepository repo = new ProductRepository();
        Book Inspector = new Book();

        repo.save(Inspector);
        repo.findById(1);

        Product[] expected = new Product[]{Inspector};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoItem() {
        ProductRepository repo = new ProductRepository();
        Book Inspector = new Book();
        Smartphone IPhone = new Smartphone();

        repo.save(Inspector);
        repo.save(IPhone);

        Product[] expected = new Product[]{Inspector, IPhone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdOneProduct() {
        ProductRepository repo = new ProductRepository();
        Book Inspector = new Book(1, "Ревизор", 200, "М.Горький");

        repo.save(Inspector);
        repo.findById(1);

        Product[] expected = new Product[]{Inspector};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdTwoProduct() {
        ProductRepository repo = new ProductRepository();
        Book Inspector = new Book(2, "Ревизор", 200, "М.Горький");
        Smartphone IPhone = new Smartphone(3, "IPhone", 500, "Apple");

        repo.save(Inspector);
        repo.save(IPhone);

        Product[] expected = new Product[]{Inspector, IPhone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}