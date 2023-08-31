package com.feguiluz.calculator.domain.usecases;

import java.math.BigDecimal;
import java.util.List;

import com.feguiluz.calculator.domain.usecases.common.CommonOperationUseCase;

public interface SubtractionOperationUseCase extends CommonOperationUseCase{
    
    @Override
    BigDecimal execute(List<BigDecimal> operands);

}
