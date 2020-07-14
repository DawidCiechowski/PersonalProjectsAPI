package com.projectsapi.exception;

public class ProjectNotFoundException extends RuntimeException {
    
    public ProjectNotFoundException(Long id) {
        super("Could not find project " + id);
    }
}