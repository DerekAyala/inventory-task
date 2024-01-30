package com.example.inventory;

import com.example.inventory.controller.ProductController;
import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productService.getAllProducts()).thenReturn(products);

        String viewName = productController.getAllProducts(model);

        assertEquals("product-list", viewName);
        verify(model, times(1)).addAttribute(eq("products"), anyList());
    }

    @Test
    void testShowAddProductForm() {
        String viewName = productController.showAddProductForm(model);

        assertEquals("add-product", viewName);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        String viewName = productController.addProduct(product);

        assertEquals("redirect:/products", viewName);
        verify(productService, times(1)).addProduct(eq(product));
    }

    @Test
    void testShowUpdateProductForm() {
        long productId = 1L;
        Product mockProduct = new Product();
        when(productService.getProductById(productId)).thenReturn(mockProduct);

        String viewName = productController.showUpdateProductForm(productId, model);

        assertEquals("update-product", viewName);
        verify(model, times(1)).addAttribute(eq("product"), eq(mockProduct));
    }

    @Test
    void testUpdateProduct() {
        long productId = 1L;
        Product product = new Product();
        String viewName = productController.updateProduct(productId, product);

        assertEquals("redirect:/products", viewName);
        verify(productService, times(1)).updateProduct(eq(productId), eq(product));
    }
}
