package com.feguiluz.calculator.apirest.controller;

import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.openapi.api.CalculatorApi;
import com.feguiluz.openapi.model.OperationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorApiController implements CalculatorApi {

    @Override
    public ResponseEntity<OperationResult> calculate(BigDecimal firstOperand, BigDecimal secondOperand, String operation) {
        throw new CalculatorException(AppErrorCode.INTERNAL_ERROR);
    }


}
