package com.projectsapi.exception;

public class ApiKeyMissingException extends RuntimeException {
    
    public ApiKeyMissingException(Long id) {
        super("Api key is missing in a header.");
    }
}