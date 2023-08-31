package com.feguiluz.calculator.application.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.feguiluz.calculator.domain.entity.OperationData;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.calculator.domain.usecases.AdditionOperationUseCase;
import com.feguiluz.calculator.domain.usecases.OperationDispatcherUseCase;
import com.feguiluz.calculator.domain.usecases.SubtractionOperationUseCase;

@ExtendWith(MockitoExtension.class)
class OperationDispatcherUseCaseImplTest {

    private static final BigDecimal RESULT = BigDecimal.valueOf(10f);
    
    @Mock
    private AdditionOperationUseCase additionOperationUseCase;

    @Mock
    private SubtractionOperationUseCase subtractionOperationUseCase;

    private OperationDispatcherUseCase operationDispatcherUseCase;

    @BeforeEach
    void setUp() {
        this.operationDispatcherUseCase = new OperationDispatcherUseCaseImpl(additionOperationUseCase,subtractionOperationUseCase);
    }

    @Test
    @DisplayName("Given an operation data when operation type is null then new CalculatorException is thrown")
    void given_an_operation_data_when_operation_type_is_null_then_new_calculator_exception_is_thrown() {
        
        final OperationData operationData = OperationData.builder()
            .operationType("OPERATION")
            .build();

        assertThrows(CalculatorException.class, () -> operationDispatcherUseCase.execute(operationData));

    }

    @Test
    @DisplayName("Given an operation data when operation type is addition then BigDecimal result is returned")
    void given_an_operation_data_when_operation_type_is_addition_then_bigdecimal_result_is_returned() {
        
        final OperationData operationData = OperationData.builder()
            .operationType("ADDITION")
            .build();

        when(additionOperationUseCase.execute(any())).thenReturn(RESULT);

        final BigDecimal result = operationDispatcherUseCase.execute(operationData);

        assertThat(result, not(nullValue()));
        assertThat(result, is(equalTo(RESULT)));

        verify(additionOperationUseCase, times(1)).execute(any());

    }
    
    @Test
    @DisplayName("Given an operation data when operation type is subtraction then BigDecimal result is returned")
    void given_an_operation_data_when_operation_type_is_subtraction_then_bigdecimal_result_is_returned() {
        
        final OperationData operationData = OperationData.builder()
            .operationType("SUBTRACTION")
            .build();

        when(subtractionOperationUseCase.execute(any())).thenReturn(RESULT);

        final BigDecimal result = operationDispatcherUseCase.execute(operationData);

        assertThat(result, not(nullValue()));
        assertThat(result, is(equalTo(RESULT)));

        verify(subtractionOperationUseCase, times(1)).execute(any());

    }
    
}
