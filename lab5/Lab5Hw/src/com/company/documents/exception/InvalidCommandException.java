package com.company.documents.exception;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}