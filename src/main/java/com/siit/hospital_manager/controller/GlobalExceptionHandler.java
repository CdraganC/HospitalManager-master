package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.exception.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<CustomErrorResponse> handle(BusinessException exception){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setPrettyMessage(exception.getMessage());
        customErrorResponse.setErrorCode(exception.getHttpStatus().toString());
        return ResponseEntity.status(exception.getHttpStatus()).body(customErrorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        return methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                .map(entry -> Map.of("Invalid field: " + Objects.requireNonNull(entry.getField()), "Rejected value: " + entry.getRejectedValue() + ". Reason:" + entry.getDefaultMessage()))
                .toList();
    }
}
