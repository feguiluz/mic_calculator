package com.feguiluz.calculator.domain.error;

public class AppErrorCode {

    public static final AppError SUCCESSFUL = new AppError(200, "The operation has been successfully resolved");

    public static final AppError INVALID_REQUEST_ERROR = new AppError(400, "An error occurred with data values");

    public static final AppError INTERNAL_SERVER_ERROR = new AppError(500, "An internal server error occurred");

    public static final AppError NOT_IMPLEMENTED_ERROR = new AppError(501, "An error occurred with not implemented funcionality");

}
