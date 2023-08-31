package com.feguiluz.calculator.apirest.controller;

import com.feguiluz.calculator.domain.usecases.OperationDispatcherUseCase;
import com.feguiluz.openapi.model.OperationResult;

import io.corp.calculator.TracerImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorApiControllerTest {

    private static final BigDecimal FIRST_OPERAND = BigDecimal.valueOf(10.5f);
    private static final BigDecimal SECOND_OPERAND = BigDecimal.valueOf(3.8f);
    private static final List<BigDecimal> OPERANDS = Arrays.asList(FIRST_OPERAND, SECOND_OPERAND);
    private static final String ADD_OPERATION = "add";

    @Mock
    private TracerImpl tracer;

    @Mock
    private OperationDispatcherUseCase operationDispatcherUseCase;

    private CalculatorApiController controller;

    @BeforeEach
    void setUp() {
        this.controller = new CalculatorApiController(tracer, operationDispatcherUseCase);
    }

    @Test
    @DisplayName("Given operands and operation when calculate method is called then exception is thrown")
    void given_operands_and_operation_when_calculate_method_is_called_then_exception_is_thrown() {

        when(operationDispatcherUseCase.execute(any())).thenReturn(FIRST_OPERAND);

        final ResponseEntity<OperationResult> result = controller.calculate(ADD_OPERATION, OPERANDS);

        assertThat(result, not(nullValue()));
        assertThat(result.getStatusCode().is2xxSuccessful(), is(true));
        assertThat(result.getBody().getResultValue(), is(equalTo(FIRST_OPERAND)));

        verify(operationDispatcherUseCase, Mockito.times(1)).execute(any());
    }

}
