package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void addProduct() {
        // Mock data
       // Product product = new Product();
        // You need to set properties of the product here as needed for the test

        // Mock stock
        Stock stock = new Stock(1L,"BERSHKA",null);

        // Save the stock
        Stock savedStock = stockRepository.save(stock);

        // Set the stock ID for the product
       // product.setStock(savedStock);

        // Save the product
      //  Product savedProduct = productService.addProduct(product, stockId);

        // Assertions
        assertNotNull(savedStock);
    }
}
