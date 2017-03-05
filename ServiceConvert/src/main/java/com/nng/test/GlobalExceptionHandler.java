package com.nng.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nng.test.exception.WrongUserNameException;

import org.springframework.http.HttpStatus; 

@ControllerAdvice  
@RestController 
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = WrongUserNameException.class)  
    public String handleWrongUserNameException(WrongUserNameException e){  
        return "Username could not be number.";  
    }
	
}
