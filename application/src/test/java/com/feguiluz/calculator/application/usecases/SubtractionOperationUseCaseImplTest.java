package com.feguiluz.calculator.application.usecases;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.calculator.domain.usecases.SubtractionOperationUseCase;

@ExtendWith(MockitoExtension.class)
class SubtractionOperationUseCaseImplTest {
    
    private static final List<BigDecimal> OPERANDS_OK = Arrays.asList(BigDecimal.valueOf(5f), BigDecimal.valueOf(3f));

    private static final List<BigDecimal> OPERANDS_KO = Arrays.asList(BigDecimal.valueOf(5f));
    
    private SubtractionOperationUseCase subtractionOperationUseCase;

    @BeforeEach
    void setUp() {
        this.subtractionOperationUseCase = new SubtractionOperationUseCaseImpl();
    }

    @Test
    @DisplayName("Given an ok operands when execute is called operation result is returned")
    void given_an_ok_operands_when_execute_is_called_operation_result_is_returned() {
        
        final BigDecimal result = subtractionOperationUseCase.execute(OPERANDS_OK);

        assertThat(result, not(nullValue()));
        assertThat(result, is(equalTo(OPERANDS_OK.get(0).subtract(OPERANDS_OK.get(1)))));

    }

    @Test
    @DisplayName("Given an ko operands when execute is called CalculatorException is thrown")
    void given_an_ko_operands_when_execute_is_called_calculator_exception_is_thrown() {
        
        Assertions.assertThrows(CalculatorException.class, () -> subtractionOperationUseCase.execute(OPERANDS_KO));

    }

}
