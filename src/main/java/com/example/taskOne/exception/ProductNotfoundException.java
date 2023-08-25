package com.example.taskOne.exception;

import java.io.Serial;

public class ProductNotfoundException extends RuntimeException{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ProductNotfoundException(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Serial
    private static final long serialVersionUID = 1L;
}

