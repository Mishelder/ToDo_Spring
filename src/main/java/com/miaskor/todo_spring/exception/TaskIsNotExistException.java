package com.miaskor.todo_spring.exception;

public class TaskIsNotExistException extends RuntimeException{
    public TaskIsNotExistException(String message) {
        super(message);
    }
}
