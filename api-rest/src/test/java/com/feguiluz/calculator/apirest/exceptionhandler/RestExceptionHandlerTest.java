package com.feguiluz.calculator.apirest.exceptionhandler;

import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.openapi.model.OperationResult;

import io.corp.calculator.TracerImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

    @Mock
    private TracerImpl tracerImpl;

    private RestExceptionHandler restExceptionHandler;

    @BeforeEach
    void setUp() {
        this.restExceptionHandler = new RestExceptionHandler(tracerImpl);
    }

    @Test
    @DisplayName("Given a CalculatorException when handle error is called then error response entity is returned")
    void given_a_calculator_exception_when_handle_error_is_called_then_error_response_entity_is_returned() {

        final ResponseEntity<OperationResult> result = restExceptionHandler.handleError(new CalculatorException(AppErrorCode.INVALID_REQUEST_ERROR));

        asserts(result);

        assertAll(
                () -> assertThat(result.getStatusCode().is4xxClientError(), is(Boolean.TRUE)),
                () -> assertThat(result.getBody().getResultMessage(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.message()))),
                () -> assertThat(result.getBody().getResultCode(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.code()))));
    }

    @Test
    @DisplayName("Given a MethodArgumentTypeMismatchException when handle error is called then error response entity is returned")
    void given_a_method_argument_type_mismatch_exception_when_handle_error_is_called_then_error_response_entity_is_returned() {

        final ResponseEntity<OperationResult> result = restExceptionHandler.handleError(new MethodArgumentTypeMismatchException(null, null, null, null, null));

        asserts(result);

        assertAll(
                () -> assertThat(result.getStatusCode().is4xxClientError(), is(Boolean.TRUE)),
                () -> assertThat(result.getBody().getResultMessage(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.message()))),
                () -> assertThat(result.getBody().getResultCode(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.code()))));
    }
    
    @Test
    @DisplayName("Given a MissingServletRequestParameterException when handle error is called then error response entity is returned")
    void given_a_missing_servlet_request_parameter_exception_when_handle_error_is_called_then_error_response_entity_is_returned() {

        final ResponseEntity<OperationResult> result = restExceptionHandler.handleError(new MissingServletRequestParameterException(null, null, false));

        asserts(result);

        assertAll(
                () -> assertThat(result.getStatusCode().is4xxClientError(), is(Boolean.TRUE)),
                () -> assertThat(result.getBody().getResultMessage(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.message()))),
                () -> assertThat(result.getBody().getResultCode(), is(equalTo(AppErrorCode.INVALID_REQUEST_ERROR.code()))));
    }

    private void asserts(final ResponseEntity<OperationResult> result) {
        assertAll(
                () -> assertThat(result, not(nullValue())),
                () -> assertThat(result.getBody(), not(nullValue())),
                () -> assertThat(result.getBody().getResultValue(), nullValue()));
    }

}
