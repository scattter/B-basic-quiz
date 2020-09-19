package com.example.demo.exception;

public class UserIdNotExistException extends RuntimeException {
    public UserIdNotExistException(String message) {
        super(message);
    }
}
