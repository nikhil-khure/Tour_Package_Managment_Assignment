package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.swaggerdocs;

import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices.ResourceNotFoundErrorResponse;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices.ValidationErrorResponse;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.dto.TourPackageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface TourApiDocs {
    @Operation(summary = "Get all Packages")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Tours fetched successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TourPackageDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No tours found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResourceNotFoundErrorResponse.class)
                    )
            )
    })
    ResponseEntity<?> getALlPackages();

    @Operation(summary = "Create new package")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Tour created successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TourPackageDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorResponse.class)
                    )
            )
    })
    ResponseEntity<?> createPackage(TourPackageDto tourPackageData);

    @Operation(summary = "Get package by Id")
    @Parameter(name = "id", description = "Tour ID", required = true, example = "5")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Tour Package fetched successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TourPackageDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No tours found with given ID",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResourceNotFoundErrorResponse.class)
                    )
            )
    })
    ResponseEntity<?> getPackageById(Long id);

    @Operation(summary = "Search package by location" , description = "ex: /api/tours/search?location=Leh")
    @Parameter(name = "location", description = "Search by location", example = "Leh")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Tour Package Searched successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TourPackageDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No tours found with given location",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResourceNotFoundErrorResponse.class)
                    )
            )
    })
    ResponseEntity<?> getEntityByLocation(String location);
}
