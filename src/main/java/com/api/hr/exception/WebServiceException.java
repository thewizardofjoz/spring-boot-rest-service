package com.api.hr.exception;


import org.springframework.http.HttpStatus;

public class WebServiceException extends RuntimeException {

    private Error error;
    private HttpStatus status;

    public WebServiceException(CommonError errors) {
        error = ExceptionUtil.buildError(errors.name(), errors.getDescription());
        status = errors.getStatus();
    }

    public WebServiceException(final Error error, final HttpStatus status) {
        super(error.getMessage());
        this.error = error;
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
