package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tour_package")
public class TourPackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgurl;

    private Float discountInPercentage;

    private String title;

    @Column(length = 1000)
    private String description;

    private String duration;

    private Double actualPrice;

    private Double discountedPrice;
}