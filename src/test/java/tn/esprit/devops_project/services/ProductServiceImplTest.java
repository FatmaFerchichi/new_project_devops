package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

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
        Stock stock = new Stock(1L,"BERSHKA",null);
        Stock savedStock = stockRepository.save(stock);
        // Mock repository method
     //   when(stockRepository.save(stock)).thenReturn(stock);

        // Perform the action


        // Assertions
        assertNotNull(savedStock);
    }
}
