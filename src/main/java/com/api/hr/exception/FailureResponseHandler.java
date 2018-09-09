package com.api.hr.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class FailureResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Error> handleAllExceptions(final Exception e, final WebRequest request) {
    return new ResponseEntity<>(ExceptionUtil.buildError(CommonError.INTERNAL_SERVICE_ERROR),
        CommonError.INTERNAL_SERVICE_ERROR.getStatus());
  }

  @ExceptionHandler(WebServiceException.class)
  public final ResponseEntity<Error> handleWebServiceException(final WebServiceException e, final WebRequest request) {
    return new ResponseEntity<>(e.getError(), e.getStatus());
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    final Error error = ExceptionUtil.buildError(CommonError.VALIDATION_ERROR);
    List<Detail> Details = ex.getBindingResult().getFieldErrors().stream()
        .map(fieldError -> ExceptionUtil.mapFieldError(fieldError)).collect(
            Collectors.toList());
    error.setDetails(Details);
    return new ResponseEntity(error, status);
  }


}
