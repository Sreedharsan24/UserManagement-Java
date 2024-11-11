package com.example.demo.exceptions;

public class FieldValidationException extends RuntimeException {
    private final String fieldName;

    public FieldValidationException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
