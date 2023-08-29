package com.feguiluz.calculator.apirest.exceptionhandler;

import com.feguiluz.calculator.apirest.mapper.AppMapErrorCodes;
import com.feguiluz.calculator.domain.error.AppError;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.openapi.model.OperationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CalculatorException.class)
    public ResponseEntity<OperationResult> handleError(final CalculatorException ex) {
        final OperationResult operationResult = buildResultError(ex.getAppError());
        return ResponseEntity.status(AppMapErrorCodes.errorMappings.get(operationResult.getResultCode())).body(operationResult);
    }

    private OperationResult buildResultError(final AppError appError) {
        final OperationResult operationResult = new OperationResult();
        operationResult.setResultCode(appError.code());
        operationResult.setResultMessage(appError.message());
        return operationResult;
    }

}
