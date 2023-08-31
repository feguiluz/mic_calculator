package com.feguiluz.calculator.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OperationData {

    private String operationType;
    
    private List<BigDecimal> operands;
}
