package com.buyonix.productservice.exceptions;

import com.buyonix.productservice.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateProductException.class)
    public ResponseEntity<APIResponse> handleDuplicateProduct(DuplicateProductException ex){
        APIResponse<Void> response = new APIResponse<>(false, HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<APIResponse> handleProductNotFound(ProductNotFoundException ex){
        APIResponse<Void> response = new APIResponse<>(false,HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> globalHandler(Exception ex){
        APIResponse<Void> response = new APIResponse<>(false,HttpStatus.INTERNAL_SERVER_ERROR.value(), "Some Error Occured : "+ex.getMessage(), null);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
