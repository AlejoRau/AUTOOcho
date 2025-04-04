package com.example.auto_market.errors;


import com.example.auto_market.responses.ApiResponseDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {

    private ResponseEntity<ApiResponseDto> buildErrorResponse(HttpStatus status, String message ) {
        ApiResponseDto error = ApiResponseDto.builder().status(status.value())
                .message(message)
                .error(true)
                .build();
        return new ResponseEntity<>(error, status);
    }

    private ResponseEntity<ApiResponseDto> buildCompleteErrorResponse(HttpStatus status, String message, List<String> fieldError)
    {
        ApiResponseDto error = ApiResponseDto.builder().status(status.value())
                .message(message)
                .errorsList(fieldError)
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto> handleException(Exception e) {
        log.error("Caught exception", e);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponseDto> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Caught exception", e);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponseDto> handleBadCredentialsException(BadCredentialsException e) {
        log.error("Caught exception", e);
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Incorrect username or password");
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponseDto> handleIllegalStateException(IllegalStateException e) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponseDto> handleEntityNotFoundException(EntityNotFoundException e) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiResponseDto> handleEntityExistsException(EntityExistsException e) {
        return buildErrorResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        return buildCompleteErrorResponse(HttpStatus.BAD_REQUEST, "Error validating data", errors);
    }


}