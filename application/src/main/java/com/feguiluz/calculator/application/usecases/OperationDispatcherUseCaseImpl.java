package com.feguiluz.calculator.application.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.feguiluz.calculator.domain.entity.OperationData;
import com.feguiluz.calculator.domain.entity.OperationType;
import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.exception.CalculatorException;
import com.feguiluz.calculator.domain.usecases.AdditionOperationUseCase;
import com.feguiluz.calculator.domain.usecases.OperationDispatcherUseCase;
import com.feguiluz.calculator.domain.usecases.SubtractionOperationUseCase;

import lombok.RequiredArgsConstructor;

import static com.feguiluz.calculator.domain.mapper.OperationTypeMapOperator.operationMappings;

@Component
@RequiredArgsConstructor
public class OperationDispatcherUseCaseImpl implements OperationDispatcherUseCase {

    private final AdditionOperationUseCase additionOperationUseCase;
    private final SubtractionOperationUseCase subtractionOperationUseCase;

    @Override
    public BigDecimal execute(OperationData operationData) {
        
        OperationType operationType = operationMappings.get(operationData.getOperationType().toUpperCase());

        if(null != operationType) {
            switch (operationType) {
                case ADDITION:
                    return additionOperationUseCase.execute(operationData.getOperands());
                case SUBTRACTION:
                    return subtractionOperationUseCase.execute(operationData.getOperands());
            }
        }

        throw new CalculatorException(AppErrorCode.NOT_IMPLEMENTED_ERROR);
    }
    
}
