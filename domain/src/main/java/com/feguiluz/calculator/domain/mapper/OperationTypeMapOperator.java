package com.feguiluz.calculator.domain.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.feguiluz.calculator.domain.entity.OperationType;

public class OperationTypeMapOperator {
    
    public static final Map<String, OperationType> operationMappings = new HashMap<>();

    static {
        operationMappings.put("ADDITION", OperationType.ADDITION);
        operationMappings.put("ADD", OperationType.ADDITION);
        operationMappings.put("SUM", OperationType.ADDITION);
        operationMappings.put("PLUS", OperationType.ADDITION);

        operationMappings.put("SUBTRACTION", OperationType.SUBTRACTION);
        operationMappings.put("SUBTRACT", OperationType.SUBTRACTION);
        operationMappings.put("SUBTR", OperationType.SUBTRACTION);
        operationMappings.put("MINUS", OperationType.SUBTRACTION);
    }

}
