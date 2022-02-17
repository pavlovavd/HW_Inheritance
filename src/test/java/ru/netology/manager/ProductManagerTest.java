package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    private Product first = new Product(1, "first", 100);
    private Book Inspector = new Book(2, "Ревизор", 200, "М.Горький");
    private Smartphone IPhone = new Smartphone(3, "IPhone", 500, "Apple");

    @Test
    public void shouldAddOneProduct() {
        manager.add(first);

        Product[] expected = new Product[]{first};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTwoProduct() {
        manager.add(first);
        manager.add(Inspector);

        Product[] expected = new Product[]{first, Inspector};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeProduct() {
        manager.add(first);
        manager.add(Inspector);
        manager.add(IPhone);

        Product[] expected = new Product[]{first, Inspector, IPhone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddOneProduct() {
        manager.add(first);

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("first");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddTwoProduct() {
        manager.add(first);
        manager.add(Inspector);

        Product[] expected = new Product[]{Inspector};
        Product[] actual = manager.searchBy("Ревизор");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddThreeProduct() {
        manager.add(first);
        manager.add(Inspector);
        manager.add(IPhone);

        Product[] expected = new Product[]{IPhone};
        Product[] actual = manager.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }
}