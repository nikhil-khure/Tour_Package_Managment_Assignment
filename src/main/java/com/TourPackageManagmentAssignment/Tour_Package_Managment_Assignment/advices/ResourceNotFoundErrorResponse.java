package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ResourceNotFoundErrorResponse {

    @Schema(example = "404")
    private HttpStatus status;
    @Schema(example = "Tour data is not found")
    private String message;
    @Schema(example = "2025-08-21T12:34:56")
    private LocalDateTime localDateTime;
}
