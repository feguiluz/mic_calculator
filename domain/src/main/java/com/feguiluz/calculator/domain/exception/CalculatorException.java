package com.feguiluz.calculator.domain.exception;

import com.feguiluz.calculator.domain.error.AppError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculatorException extends RuntimeException {

    private final @Getter AppError appError;

    public CalculatorException(final AppError appError, final Throwable t) {
        super(t);
        this.appError = appError;
    }

}
