package com.example.taskOne.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String message;
    private HttpStatus status;

    public ExceptionResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }


}
