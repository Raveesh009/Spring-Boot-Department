package com.example.springBoot.exception;

import com.example.springBoot.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions
// across the whole application in one global handling component.
@ControllerAdvice

//@ResponseStatus marks a method or exception class with the status code and reason message that should be returned.
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception){

      ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
              exception.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
