package com.buyonix.resgistryservice.exceptions;

import com.buyonix.resgistryservice.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<APIResponse<Void>> handleDuplicateUser(DuplicateUserException ex){
        APIResponse<Void> apiResponse = new APIResponse<>(false,HttpStatus.CONFLICT.value(), ex.getMessage(),null);
        return new ResponseEntity<>(apiResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse<Void>> handleUserNotFound(UserNotFoundException ex){
        APIResponse<Void> apiResponse = new APIResponse<>(false,HttpStatus.NOT_FOUND.value(), ex.getMessage(),null);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<APIResponse<Void>> handleGlobal(Exception ex){
        APIResponse<Void> apiResponse = new APIResponse<>(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + ex.getMessage(),null);
        return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
