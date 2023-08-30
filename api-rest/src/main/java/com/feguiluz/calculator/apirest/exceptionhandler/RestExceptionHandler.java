package com.feguiluz.calculator.apirest.exceptionhandler;

import com.feguiluz.calculator.apirest.mapper.AppMapErrorCodes;
import com.feguiluz.calculator.domain.error.AppError;
import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.openapi.model.OperationResult;

import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    private final TracerImpl tracer;

    @ExceptionHandler(CalculatorException.class)
    public ResponseEntity<OperationResult> handleError(final CalculatorException ex) {
        tracer.trace(ex.getAppError());
        final OperationResult operationResult = buildResultError(ex.getAppError());
        return ResponseEntity.status(AppMapErrorCodes.errorMappings.get(operationResult.getResultCode())).body(operationResult);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<OperationResult> handleError(final MethodArgumentTypeMismatchException ex) {
        tracer.trace(AppErrorCode.INVALID_REQUEST_ERROR.message());
        final OperationResult operationResult = buildResultError(AppErrorCode.INVALID_REQUEST_ERROR);
        return ResponseEntity.status(AppMapErrorCodes.errorMappings.get(operationResult.getResultCode())).body(operationResult);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<OperationResult> handleError(final MissingServletRequestParameterException ex) {
        tracer.trace(AppErrorCode.INVALID_REQUEST_ERROR.message());
        final OperationResult operationResult = buildResultError(AppErrorCode.INVALID_REQUEST_ERROR);
        return ResponseEntity.status(AppMapErrorCodes.errorMappings.get(operationResult.getResultCode())).body(operationResult);
    }

    private OperationResult buildResultError(final AppError appError) {
        final OperationResult operationResult = new OperationResult();
        operationResult.setResultCode(appError.code());
        operationResult.setResultMessage(appError.message());
        return operationResult;
    }

}
