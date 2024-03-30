package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OperatorServiceImplTest {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private OperatorServiceImpl operatorService;

    @Test
    void retrieveAllOperators() {
        // Mock data
        Operator operator1 = new Operator();
        operator1.setIdOperateur(1L);
        operator1.setFname("Ferchichi");
        operator1.setLname("Fatma");

        // Save the mock data to the repository
        operatorRepository.save(operator1);

        // Act
        Operator retrievedOperator = operatorService.retrieveOperator(1L);

        // Assert
        assertNotNull(retrievedOperator);
        assertEquals(1L, retrievedOperator.getIdOperateur());
        assertEquals("Ferchichi", retrievedOperator.getFname()); // Compare with the expected value


    }

    @Test
    void testDeleteOperator() {
        // Mock data
        Long idToDelete = 1L;
        Operator operatorToDelete = new Operator();
        operatorToDelete.setIdOperateur(idToDelete);
        operatorRepository.save(operatorToDelete);

        // Call the method to be tested
        operatorService.deleteOperator(idToDelete);

        // Assert that the operator is deleted
        assertFalse(operatorRepository.existsById(idToDelete));
    }

}
