package com.feguiluz.calculator.domain.error;

public class AppErrorCode {

    public static final AppError INVALID_REQUEST_ERROR = new AppError(400, "An error occurred with data values");

    public static final AppError INTERNAL_ERROR = new AppError(500, "An internal error occurred");

}
