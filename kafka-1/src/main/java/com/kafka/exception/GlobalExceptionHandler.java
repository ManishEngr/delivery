package com.kafka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kafka.dto.ResponseWrapper;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper<String>> handleRuntimeException(RuntimeException ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(
                "Error",
                "An unexpected error occurred",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>> handleGeneralException(Exception ex) {
        ResponseWrapper<String> response = new ResponseWrapper<>(
                "Error",
                "An error occurred",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
