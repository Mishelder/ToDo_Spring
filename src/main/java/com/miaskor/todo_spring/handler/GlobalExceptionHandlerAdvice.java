package com.miaskor.todo_spring.handler;

import com.miaskor.todo_spring.exception.ClientIsNotExistException;
import com.miaskor.todo_spring.exception.TaskIsNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> clientIncorrectID(ClientIsNotExistException exception){
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> taskIncorrectID(TaskIsNotExistException exception){
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> clientIncorrectFormatID(NumberFormatException exception){
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }
}
