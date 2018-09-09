package com.api.hr.exception;


import org.springframework.validation.FieldError;

public class ExceptionUtil {

    public static Error buildError(CommonError errors) {
        return buildError(errors.name(), errors.getDescription());
    }

    public static Error buildError(String errorName, String message) {
        final Error error = new Error();
        error.setName(errorName);
        error.setMessage(message);
        return error;
    }

    public static Detail mapFieldError(FieldError fieldError) {
        final Detail detail = new Detail();
        detail.setField(fieldError.getField());
        detail.setIssue(fieldError.getDefaultMessage());
//        detail.setValue(fieldError.getRejectedValue());

        return detail;
    }
}
