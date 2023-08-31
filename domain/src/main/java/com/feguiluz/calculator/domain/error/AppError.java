package com.feguiluz.calculator.domain.error;

import java.io.Serial;
import java.io.Serializable;

public record AppError(Integer code, String message) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public AppError withMessage(String message) {
        return new AppError(code(), message);
    }

    @Override
    public String toString() {
        return message();
    }

}
