package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class OperatorServiceImplTest {

    @Autowired
    private OperatorServiceImpl operatorService;

    @MockBean
    private OperatorRepository operatorRepository;

    @Test
    void retrieveAllOperators() {
        // Mock data
        Operator operator1 = new Operator();
        operator1.setIdOperateur(1L);
        operator1.setFname("Ferchichi");
        operator1.setLname("Fatma");

        // Mock repository behavior
        when(operatorRepository.findById(1L)).thenReturn(Optional.of(operator1));

        // Act
        Operator retrievedOperator = operatorService.retrieveOperator(1L);

        // Assert
        assertNotNull(retrievedOperator);
        assertEquals(1L, retrievedOperator.getIdOperateur());
        assertEquals("Ferchichi", retrievedOperator.getFname()); // Compare with the expected value
    }
}
