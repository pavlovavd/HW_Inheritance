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
    private Book inspector = new Book(2, "Ревизор", 200, "М.Горький");
    private Smartphone iPhone = new Smartphone(3, "IPhone", 500, "Apple");

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
        manager.add(inspector);

        Product[] expected = new Product[]{first, inspector};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeProduct() {
        manager.add(first);
        manager.add(inspector);
        manager.add(iPhone);

        Product[] expected = new Product[]{first, inspector, iPhone};
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
        manager.add(inspector);

        Product[] expected = new Product[]{inspector};
        Product[] actual = manager.searchBy("Ревизор");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddThreeProduct() {
        manager.add(first);
        manager.add(inspector);
        manager.add(iPhone);

        Product[] expected = new Product[]{iPhone};
        Product[] actual = manager.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddTwoProductOneCategory() {
        Product second = new Product(2, "second", 100);
        manager.add(first);
        manager.add(second);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("second");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenAddTwoProductCategorySmartphone() {
        Smartphone samsung = new Smartphone(4, "GalaxyS20", 5000, "Samsung");
        manager.add(first);
        manager.add(samsung);

        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy("GalaxyS20");
        assertArrayEquals(expected, actual);
    }
}