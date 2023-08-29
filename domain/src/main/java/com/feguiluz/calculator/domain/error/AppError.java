package com.feguiluz.calculator.domain.error;

import java.io.Serial;
import java.io.Serializable;

public record AppError(Integer code, String message) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
