package com.cabride.cabride.service;

import com.cabride.cabride.entity.Ride;

import java.util.List;
import java.util.Optional;

public interface RideService {
    void save(Ride ride);
    Ride update(Long id,Ride ride) throws Exception;
    Integer totalTrips();
    Integer totalTripsCity(String city);
    Integer totalTripsCoutry(String country);
    List<Ride> currentTrips();

}
