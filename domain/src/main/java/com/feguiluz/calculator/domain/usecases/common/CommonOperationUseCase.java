package com.feguiluz.calculator.domain.usecases.common;

import java.math.BigDecimal;
import java.util.List;

public interface CommonOperationUseCase extends CommonUseCase<List<BigDecimal>,BigDecimal>{
    
    @Override
    BigDecimal execute(List<BigDecimal> operands);
    
}
