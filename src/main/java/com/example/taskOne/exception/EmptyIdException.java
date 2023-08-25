package com.example.taskOne.exception;

public class EmptyIdException extends RuntimeException{


    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
