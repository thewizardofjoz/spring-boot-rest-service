package com.api.hr.exception;

public class ResourceNotFoundException extends WebServiceException {

    public ResourceNotFoundException() {
        super(CommonError.INVALID_RESOURCE_ID);
    }
}
