package com.example.demo.Exception;

public class UserIdNotExistException extends RuntimeException {
    public UserIdNotExistException(String message) {
        super(message);
    }
}
