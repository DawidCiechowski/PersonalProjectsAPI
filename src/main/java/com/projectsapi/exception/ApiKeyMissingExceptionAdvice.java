package com.projectsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiKeyMissingExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ApiKeyMissingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String apiKeyNotFoundAdvice(ApiKeyMissingException ex) {
        return ex.getMessage();
    }
}