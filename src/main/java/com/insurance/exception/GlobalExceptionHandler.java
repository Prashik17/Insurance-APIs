package com.insurance.exception;
/*handle exceptions centrally instead of writing error handling code in
multiple controllers. This improves code organization and reusability.*/

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    // 1️. Handle Bill Not Found Exception
	
    @ExceptionHandler(BillNotFoundException.class)   //Handling Specific Exception
    public ResponseEntity<Map<String, String>> handleBillNotFoundException(BillNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());    //Stores the error message using ex.getMessage()the message from the exception &Creating a Custom Error Response
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        
        /*Wraps the error response in a ResponseEntity, which allows us to return a custom HTTP status.
        Returns HttpStatus.NOT_FOUND (404), indicating the requested bill was not found.*/
    }
}