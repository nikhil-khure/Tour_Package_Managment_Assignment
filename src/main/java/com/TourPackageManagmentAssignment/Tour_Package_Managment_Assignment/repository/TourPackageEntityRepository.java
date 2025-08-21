package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.repository;

import com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.entity.TourPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourPackageEntityRepository extends JpaRepository<TourPackageEntity,Long> {

    @Query(value = "SELECT * FROM tour_package WHERE description ~* CONCAT('\\y', :location, '\\y|\\y', :location, 's\\y')", nativeQuery = true)
    List<TourPackageEntity> findToursByLocation(@Param("location") String location);

}
