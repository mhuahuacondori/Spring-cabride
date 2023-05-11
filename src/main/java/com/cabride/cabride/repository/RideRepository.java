package com.cabride.cabride.repository;


import com.cabride.cabride.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    @Query(value = "select count(*) from trips.ride",nativeQuery = true)
    Integer totalTrips();

    @Query(value = "select count(*) from trips.ride where city_name = :city",nativeQuery = true)
    Integer totalTripsCity(@Param("city") String city);

    @Query(value = "select count(*) from trips.ride where country_name = :country",nativeQuery = true)
    Integer totalTripsCountry(@Param("country") String country);

    @Query(value = "select * from trips.ride where start_date >= NOW() - interval '1 day'",nativeQuery = true)
    List<Ride> currentTrips();
}
