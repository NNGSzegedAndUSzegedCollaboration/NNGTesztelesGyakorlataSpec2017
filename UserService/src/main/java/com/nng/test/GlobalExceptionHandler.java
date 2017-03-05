package com.nng.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nng.test.exception.AddUserException;
import com.nng.test.exception.GetUserException;
import com.nng.test.exception.WrongUserNameException;

import org.springframework.http.HttpStatus; 

@ControllerAdvice  
@RestController 
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)  
    @ExceptionHandler(value = GetUserException.class)  
    public String handleGetUserException(GetUserException e){  
        return "User not found.";  
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(value = AddUserException.class)  
    public String handleAddUserException(AddUserException e){  
        return "User could not be added.";  
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = WrongUserNameException.class)  
    public String handleWrongUserNameException(WrongUserNameException e){  
        return "Username could not be number.";  
    }
	
}
