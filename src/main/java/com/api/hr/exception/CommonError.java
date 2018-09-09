package com.api.hr.exception;


import org.springframework.http.HttpStatus;

public enum CommonError {
    INTERNAL_SERVICE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An internal service error has occurred."),
    INVALID_RESOURCE_ID(HttpStatus.NOT_FOUND, "The requested resource ID was not found."),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Invalid request - see details."),
    PERMISSION_DENIED(HttpStatus.UNAUTHORIZED, "No permission for the requested operation."),
    RATE_LIMIT_REACHED(HttpStatus.TOO_MANY_REQUESTS, "Too many requests. Blocked due to rate limiting.");

    private String description;
    private HttpStatus status;

    private CommonError(HttpStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
