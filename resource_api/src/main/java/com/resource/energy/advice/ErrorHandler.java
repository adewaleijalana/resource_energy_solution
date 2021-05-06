package com.resource.energy.advice;


import com.resource.energy.exception.*;
import com.resource.energy.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    private Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);
    private static final String EXCEPTION_MESSAGE = "AN EXCEPTION OCCURRED";

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            HttpServletRequest request, BadRequestException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.INPUT)
                //.message(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .message(e.getMessage())
                .build();
        LOGGER.error("Error: " + e.getMessage(), e);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest2(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toCollection(ArrayList::new));

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.INPUT)
                .message("")
                .errorMessages(errors)
                .build();
        LOGGER.error("Error: " + ex.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalError
            (HttpServletRequest request, Exception e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.PROCESSING)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse>
    httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.METHOD_NOT_ALLOWED)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundHandler(ModelNotFoundException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.NOT_FOUND)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getArgumentSupplied()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> alreadyExistHandler(ModelAlreadyExistException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.FOUND)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getArgumentSupplied()) ?
                        EXCEPTION_MESSAGE : e.getArgumentSupplied())
                .build();

        LOGGER.error("Error: " + e.getArgumentSupplied(), e);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @ExceptionHandler(ProcessingException.class)
    public ResponseEntity<ErrorResponse> notProcessingExceptionHandler(ProcessingException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.PROCESSING)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> ioExceptionHandler(IOException e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.PROCESSING)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> badCredentials
            (HttpServletRequest request, Exception e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.AUTHENTICATION)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFound
            (HttpServletRequest request, Exception e) {

        ErrorResponse response = ErrorResponse.builder()
                .error(ErrorCode.NOT_FOUND)
                .message(AppUtil.INSTANCE.stringIsNullOrEmpty(e.getMessage()) ?
                        EXCEPTION_MESSAGE : e.getMessage())
                .build();

        LOGGER.error("Error: " + e.getMessage(), e);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}