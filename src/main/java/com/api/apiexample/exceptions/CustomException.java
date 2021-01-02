package com.api.apiexample.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private String message;
    private String details;
    private String hint;

    protected CustomException() {};

    public CustomException(String message, String details, String hint) {
        this.message = message;
        this.details = details;
        this.hint = hint;
    }
}
