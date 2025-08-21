package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.controller;

import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices.ResourceNotFoundErrorResponse;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.advices.ValidationErrorResponse;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.dto.TourPackageDto;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.exceptions.LocationNotNullException;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.exceptions.ResourceNotFoundException;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.service.TourPackageService;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.swaggerdocs.TourApiDocs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@Tag(name = "Tour Package APIs")
public class TourPackageController implements TourApiDocs {

    @Autowired
    private TourPackageService tourPackageService;


    @GetMapping()
    public ResponseEntity<?> getALlPackages()
    {
        List<TourPackageDto> packageDtoList = tourPackageService.getAllPackages();
        if(!packageDtoList.isEmpty())
        {
            return new ResponseEntity<>(packageDtoList, HttpStatus.OK);
        }
        else{
            throw new ResourceNotFoundException("There are no packages in database");
        }
    }

    @PostMapping
    public ResponseEntity<?> createPackage(@RequestBody @Valid TourPackageDto tourPackageData )
    {
        tourPackageService.createPackage(tourPackageData);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPackageById(@PathVariable Long id)
    {
        TourPackageDto tourPackageDto = tourPackageService.getPackageById(id);
        if(tourPackageDto!=null)
        {
            return new ResponseEntity<>(tourPackageDto,HttpStatus.OK);
        }
        else{
            throw new ResourceNotFoundException("There is no package exist with id = "+id);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getEntityByLocation(@RequestParam (required = false) String location)
    {
        if(location!=null && !location.isBlank())
        {
            List<TourPackageDto> tourPackageDtos =tourPackageService.getEntityByLocation(location);
            if(!tourPackageDtos.isEmpty())
            {
                return new ResponseEntity<>(tourPackageDtos,HttpStatus.OK);
            }
            else{
                throw new ResourceNotFoundException("There is no package exist with location = "+location);
            }
        }
        else{
            throw new LocationNotNullException("Please Enter location in above url like location=leh");
        }
    }


}
