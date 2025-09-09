package com.example.demo3.exception;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException() {
    }

    public IncorrectRequestException(String message) {
        super(message);
    }
}
