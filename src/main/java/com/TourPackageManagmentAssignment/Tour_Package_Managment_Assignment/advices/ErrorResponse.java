package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
    private LocalDateTime localDateTime;
}

