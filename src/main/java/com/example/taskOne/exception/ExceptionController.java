package com.example.taskOne.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = ProductNotfoundException.class)
    //Response Entity postman'den bana gelen cevap, veri
    public ResponseEntity<Object> exceptionOfProductNotFound(ProductNotfoundException exception1) {
        exception1.setMessage("The product with provided id cannot found");
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception1.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = EmptyIdException.class)
    public ResponseEntity<Object> exceptionOfEmptyId(EmptyIdException exception2){
        exception2.setMessage("You didn't provide enough data");
        ExceptionResponse exceptionResponse2 = new ExceptionResponse(exception2.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse2, HttpStatus.BAD_REQUEST);
    }

    
}




