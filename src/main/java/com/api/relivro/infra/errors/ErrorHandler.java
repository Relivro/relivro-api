package com.api.relivro.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidation::new).toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<List<DataErrorValidation>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        String fieldName = ex.getRootCause().getMessage().split("\\(")[1].split("\\)")[0].split("=")[0];

        String errorMessage = ex.getRootCause().getMessage();

        List<DataErrorValidation> errors = List.of(new DataErrorValidation(fieldName, errorMessage));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    private record DataErrorValidation(String field, String message) {
        public DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
