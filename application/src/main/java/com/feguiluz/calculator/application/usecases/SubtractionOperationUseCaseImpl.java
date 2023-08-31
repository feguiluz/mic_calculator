package com.feguiluz.calculator.application.usecases;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.calculator.domain.usecases.SubtractionOperationUseCase;

@Component
public class SubtractionOperationUseCaseImpl implements SubtractionOperationUseCase {

    private static final Integer OPERANDS_SIZE_ALLOWED = 2;

    @Override
    public BigDecimal execute(List<BigDecimal> operands) {
        
        if(OPERANDS_SIZE_ALLOWED != operands.size()) {
            throw new CalculatorException(AppErrorCode.INVALID_REQUEST_ERROR
                .withMessage("The number of operators allowed for this operation is "+ OPERANDS_SIZE_ALLOWED));
        }

        return operands.get(0).subtract(operands.get(1));

    }
    
}
