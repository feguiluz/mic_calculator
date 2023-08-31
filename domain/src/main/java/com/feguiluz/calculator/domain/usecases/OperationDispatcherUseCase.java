package com.feguiluz.calculator.domain.usecases;

import java.math.BigDecimal;

import com.feguiluz.calculator.domain.entity.OperationData;
import com.feguiluz.calculator.domain.usecases.common.CommonUseCase;

public interface OperationDispatcherUseCase extends CommonUseCase<OperationData, BigDecimal>{
    
    @Override
    BigDecimal execute(OperationData operationData);

}
