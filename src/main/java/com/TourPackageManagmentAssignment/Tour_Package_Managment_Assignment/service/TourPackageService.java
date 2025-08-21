package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.service;

import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.dto.TourPackageDto;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.entity.TourPackageEntity;
import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.repository.TourPackageEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageEntityRepository tourPackageEntityRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<TourPackageDto> getAllPackages() {
        List<TourPackageEntity> packageEntityList = tourPackageEntityRepository.findAll();
        List<TourPackageDto> packageDtoList = packageEntityList
                    .stream()
                    .map(packageEntity -> modelMapper.map(packageEntity, TourPackageDto.class))
                    .toList();
            return packageDtoList;
    }

    public void createPackage(TourPackageDto tourPackageData) {
        Double discounted = tourPackageData.getActualPrice() - (tourPackageData.getActualPrice() * tourPackageData.getDiscountInPercentage() / 100);
        tourPackageData.setDiscountedPrice(discounted);
        TourPackageEntity tourPackageEntity = modelMapper.map(tourPackageData,TourPackageEntity.class);
        tourPackageEntityRepository.save(tourPackageEntity);
    }

    public TourPackageDto getPackageById(Long id) {
        TourPackageEntity tourPackageEntity = tourPackageEntityRepository.findById(id).orElse(null);
        if(tourPackageEntity!=null)
        {
            TourPackageDto tourPackageDto = modelMapper.map(tourPackageEntity,TourPackageDto.class);
            return tourPackageDto;
        }
        else{
            return null;
        }
    }

    public List<TourPackageDto> getEntityByLocation(String location) {
        List<TourPackageEntity> tourPackageEntityList = tourPackageEntityRepository.findToursByLocation(location);
        List<TourPackageDto> packageDtoList = tourPackageEntityList
                .stream()
                .map(tourPackageEntity -> modelMapper.map(tourPackageEntity, TourPackageDto.class))
                .toList();
        return packageDtoList;
    }
}
