package com.workintech.fsweb.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException apiException) {
        log.error("ApiException occured stacktrace: {}", Arrays.toString(apiException.getStackTrace()));
        log.error("ApiException occured: {}", apiException);
        log.error("ApiException occured message: {}", apiException.getMessage());
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(apiException.getHttpStatus().value(),
                apiException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiErrorResponse,apiException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception) {
        log.error("ApiException occured stacktrace: {}", Arrays.toString(exception.getStackTrace()));
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
