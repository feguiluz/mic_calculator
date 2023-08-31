package com.feguiluz.calculator.apirest.mapper;

import com.feguiluz.calculator.domain.error.AppErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AppMapErrorCodes {

    public static final Map<Integer, HttpStatus> errorMappings = new HashMap<>();

    static {
        errorMappings.put(AppErrorCode.SUCCESSFUL.code(), HttpStatus.OK);
        errorMappings.put(AppErrorCode.INVALID_REQUEST_ERROR.code(), HttpStatus.BAD_REQUEST);
        errorMappings.put(AppErrorCode.INTERNAL_SERVER_ERROR.code(), HttpStatus.INTERNAL_SERVER_ERROR);
        errorMappings.put(AppErrorCode.NOT_IMPLEMENTED_ERROR.code(), HttpStatus.NOT_IMPLEMENTED);
    }

}
