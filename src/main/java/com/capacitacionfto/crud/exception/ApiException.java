package com.capacitacionfto.crud.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ApiException {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private int code;
    private String message;
    private List<String> errors;
    private String path;

    public ApiException() {
    }

    public ApiException(HttpStatus status, int code, String message, List<String> errors, String path) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }
}
