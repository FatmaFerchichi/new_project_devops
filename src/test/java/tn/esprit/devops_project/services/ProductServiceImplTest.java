package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct() {
        // Mock data
        Product product = new Product();
        // You need to set properties of the product here as needed for the test

        // Mock stock
        Stock stock = new Stock(); // Create a mock Stock object
        Long stockId = 1L; // Example stock ID

        // Mock repository method behavior for stockRepository
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        // Mock repository method behavior for productRepository
        when(productRepository.save(product)).thenReturn(product);

        // Perform the action
        Product savedProduct = productService.addProduct(product, stockId);

        // Assertions
        assertNotNull(savedProduct);
    }
}
