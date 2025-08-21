package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ValidationErrorResponse {
    @Schema(example = "400")
    private HttpStatus status;
    @Schema(example = "Invalid input error")
    private String message;
    @Schema(example = "Sub input error")
    private List<String> subErrors;
    @Schema(example = "2025-08-21T12:34:56")
    private LocalDateTime localDateTime;
}

