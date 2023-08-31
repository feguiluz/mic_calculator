package com.feguiluz.calculator.apirest.controller;

import static com.feguiluz.calculator.apirest.mapper.AppMapErrorCodes.errorMappings;

import com.feguiluz.calculator.domain.entity.OperationData;
import com.feguiluz.calculator.domain.error.AppErrorCode;
import com.feguiluz.calculator.domain.usecases.OperationDispatcherUseCase;
import com.feguiluz.openapi.api.CalculatorApi;
import com.feguiluz.openapi.model.OperationResult;

import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalculatorApiController implements CalculatorApi {

    private static final String TRACER_SEPARATOR = "\t| ";

    private final TracerImpl tracer;

    private final OperationDispatcherUseCase operationDispatcherUseCase;

    @Override
    public ResponseEntity<OperationResult> calculate(String operationType, List<BigDecimal> operands) {
        final BigDecimal result = operationDispatcherUseCase.execute(OperationData.builder()
            .operationType(operationType)
            .operands(operands)
            .build());

        final OperationResult operationResult = buildOperationResult(result);

        tracer.trace(result + TRACER_SEPARATOR + operationResult.getResultMessage());
        return ResponseEntity.status(errorMappings.get(operationResult.getResultCode())).body(operationResult);
    }

    private OperationResult buildOperationResult(final BigDecimal result) {
        final OperationResult operationResult = new OperationResult();
        operationResult.setResultCode(AppErrorCode.SUCCESSFUL.code());
        operationResult.setResultMessage(AppErrorCode.SUCCESSFUL.message());
        operationResult.setResultValue(result);
        return operationResult;
    }


}
