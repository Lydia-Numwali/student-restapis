package com.springboot.rest.SpringBoot_RestAPI.exception;

public class ValidationException extends Exception{
    public ValidationException(String message)
    {
        super(message);
    }
}
