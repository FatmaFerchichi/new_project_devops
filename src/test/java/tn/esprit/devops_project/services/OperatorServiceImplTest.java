package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

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

        // Verify that findById method was called exactly once with the correct argument
        Mockito.verify(operatorRepository, Mockito.times(1)).findById(1L);
    }
    @Test
    void testDeleteOperator() {
        // Mock data
        Long idToDelete = 1L;
        Operator operatorToDelete = new Operator();
        operatorToDelete.setIdOperateur(idToDelete);

        // Mock repository behavior
        lenient().when(operatorRepository.findById(idToDelete)).thenReturn(Optional.of(operatorToDelete));

        // Call the method to be tested
        operatorService.deleteOperator(idToDelete);

        // Verify that deleteById method was called exactly once with the correct argument
        Mockito.verify(operatorRepository, Mockito.times(1)).deleteById(idToDelete);
    }
}