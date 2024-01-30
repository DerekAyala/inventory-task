package com.example.inventory;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", "Description 1", 5, 10.99));
        productList.add(new Product("Product 2", "Description 2", 8, 15.99));

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Product 1", result.get(0).getName());
        Assertions.assertEquals("Product 2", result.get(1).getName());
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("Product 1", "Description 1", 5, 10.99);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product result = productService.addProduct(product);

        Assertions.assertEquals("Product 1", result.getName());
    }

    @Test
    public void testGetProductById() {
        long id = 1L;
        Product product = new Product("Product 1", "Description 1", 5, 10.99);

        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(id);

        Assertions.assertEquals("Product 1", result.getName());
    }

    @Test
    public void testUpdateProduct() {
        long id = 1L;
        Product product = new Product("Product 1", "Description 1", 5, 10.99);

        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product updatedProduct = new Product("Updated Product", "New Description", 10, 14.99);
        updatedProduct.setId(id);
        Product result = productService.updateProduct(id, updatedProduct);

        Assertions.assertEquals("Updated Product", result.getName());
        Assertions.assertEquals("New Description", result.getDescription());
        Assertions.assertEquals(14.99, result.getPrice());
        Assertions.assertEquals(10, result.getQuantity());
    }
}