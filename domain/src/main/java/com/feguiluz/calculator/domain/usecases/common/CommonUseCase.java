package com.feguiluz.calculator.domain.usecases.common;

public interface CommonUseCase<T,R> {
    
    R execute(T param);

}
