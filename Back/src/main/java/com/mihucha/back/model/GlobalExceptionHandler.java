package com.mihucha.back.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("timestamp", new Date());
        objectBody.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        objectBody.put("errors", errors);

        return new ResponseEntity<>(objectBody, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(
            RuntimeException ex,
            WebRequest request) {

        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("timestamp", new Date());
        objectBody.put("status", HttpStatus.BAD_REQUEST.value());
        objectBody.put("error", "Bad Request");
        objectBody.put("message", ex.getMessage());

        return new ResponseEntity<>(objectBody, HttpStatus.BAD_REQUEST);
    }
}