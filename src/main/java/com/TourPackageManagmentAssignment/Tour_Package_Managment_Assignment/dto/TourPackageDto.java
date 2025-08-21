package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourPackageDto {

    @NotBlank(message = "Image URL is required")
    private String imgurl;

    @NotNull(message = "Discount is required")
    @DecimalMin(value = "0.0", message = "Discount cannot be less than 0%")
    @DecimalMax(value = "100.0", message = "Discount cannot be more than 100%")
    private Float discountInPercentage;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotNull(message = "Actual price is required")
    @Positive(message = "Actual price must be greater than 0")
    private Double actualPrice;

    @NotNull(message = "Discounted price is required")
    @Positive(message = "Discounted price must be greater than 0")
    private Double discountedPrice;
}
