package com.feguiluz.calculator.apirest.controller;

import com.feguiluz.calculator.domain.exception.CalculatorException;

import io.corp.calculator.TracerImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class CalculatorApiControllerTest {

    private static final BigDecimal FIRST_OPERAND = BigDecimal.valueOf(10.5f);
    private static final BigDecimal SECOND_OPERAND = BigDecimal.valueOf(3.8f);
    private static final String ADD_OPERATION = "add";

    @Mock
    private TracerImpl tracer;

    private CalculatorApiController controller;

    @BeforeEach
    void setUp() {
        this.controller = new CalculatorApiController(tracer);
    }

    @Test
    @DisplayName("Given operands and operation when calculate method is called then exception is thrown")
    void given_operands_and_operation_when_calculate_method_is_called_then_exception_is_thrown() {
        Assertions.assertThrows(CalculatorException.class, () -> controller.calculate(FIRST_OPERAND, SECOND_OPERAND, ADD_OPERATION));
    }

}
