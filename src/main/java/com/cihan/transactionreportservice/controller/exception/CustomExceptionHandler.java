package com.cihan.transactionreportservice.controller.exception;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = getDateErrorMsg(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleFeignStatusException(FeignException e, HttpServletResponse response) {
        log.warn("FeignClient Error {}", e.getMessage());

        record ErrorResponse(String errorCode, String errorMessage) {
        }
e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("PSP-01", "PSP Client Error"));
    }

    private String getDateErrorMsg(String errMsg) {
        if (errMsg.contains("required type 'java.time.LocalDate'")) {
            return "Invalid Date Format";
        }
        return errMsg;
    }

}