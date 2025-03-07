package com.insurance.exception;

/*A constructor that takes a message as a parameter.
Calls the superclass (RuntimeException) constructor to store the error message.

*we used this in billdserviceImpl*/


public class BillNotFoundException extends RuntimeException {
    public BillNotFoundException(String message) {
        super(message);
    }
}