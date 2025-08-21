package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices;

import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.exceptions.LocationNotNullException;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage("Invalid input error");
        errorResponse.setSubErrors(errors);
        errorResponse.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LocationNotNullException.class)
    public ResponseEntity<?> handleNotNullLocationException(LocationNotNullException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
