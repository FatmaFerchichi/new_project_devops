package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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
}