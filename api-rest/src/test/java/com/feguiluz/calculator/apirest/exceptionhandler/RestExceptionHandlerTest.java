package com.feguiluz.calculator.apirest.exceptionhandler;

import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.openapi.model.OperationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

    private RestExceptionHandler restExceptionHandler;

    @BeforeEach
    void setUp() {
        this.restExceptionHandler = new RestExceptionHandler();
    }

    @Test
    @DisplayName("Given a calculator exception when handle error is called then error response entity is returned")
    void given_a_calculator_exception_when_handle_error_is_called_then_error_response_entity_is_returned() {

        final ResponseEntity<OperationResult> result = restExceptionHandler.handleError(new CalculatorException(AppErrorCode.INVALID_REQUEST_ERROR));

        assertAll(
                () -> assertThat(result, not(nullValue())),
                () -> assertThat(result.getStatusCode().is4xxClientError(), is(Boolean.TRUE)),
                () -> assertThat(result.getBody(), not(nullValue())),
                () -> assertThat(result.getBody().getResultValue(), nullValue()),
                () -> assertThat(result.getBody().getResultMessage(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.message()))),
                () -> assertThat(result.getBody().getResultCode(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.code()))));
    }

}
