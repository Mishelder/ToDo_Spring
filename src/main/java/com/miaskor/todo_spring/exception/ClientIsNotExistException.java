package com.miaskor.todo_spring.exception;

public class ClientIsNotExistException extends RuntimeException{
    public ClientIsNotExistException(String message) {
        super(message);
    }
}
