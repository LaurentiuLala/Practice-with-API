package com.example.testofskills.Exceptions;

public class PlaceNotFound extends RuntimeException {
    public PlaceNotFound(String message) {
        super(message);
    }
}
