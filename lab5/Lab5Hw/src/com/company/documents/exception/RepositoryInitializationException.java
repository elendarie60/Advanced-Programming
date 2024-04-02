package com.company.documents.exception;

public class RepositoryInitializationException extends RuntimeException {
    public RepositoryInitializationException(String message) {
        super(message);
    }

    public RepositoryInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}