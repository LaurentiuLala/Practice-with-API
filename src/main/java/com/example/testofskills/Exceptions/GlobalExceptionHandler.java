package com.example.testofskills.Exceptions;


import com.example.testofskills.Models.Place;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PlaceNotFound.class)
    public ResponseEntity<Object> handleplacenotfound(PlaceNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());

    }

    @ExceptionHandler(RatingException.class)
    public ResponseEntity<Object> handleratingexception(RatingException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
