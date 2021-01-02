package com.api.apiexample.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomExceptionSchema {
    private String message;
    private String details;
    private String hint;
}
