package com.cabride.cabride.service;

import com.cabride.cabride.entity.Ride;
import com.cabride.cabride.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RideServiceImpl implements RideService {
    @Autowired
    RideRepository rideRepository;
    @Override
    public void save(Ride ride) {
        this.rideRepository.save(ride);
    }

    @Override
    public Ride update(Long id, Ride ride) throws Exception {
        Optional<Ride> optionalRide = this.rideRepository.findById(id);

        if(optionalRide.isPresent()) {
            Ride rideUpdate = optionalRide.get();
            rideUpdate.setStartDate(ride.getStartDate()==null?optionalRide.get().getStartDate():ride.getStartDate());
            rideUpdate.setStartPickupAddress(ride.getStartPickupAddress()==null?optionalRide.get().getStartPickupAddress():ride.getStartPickupAddress());
            rideUpdate.setStartPickupLocation(ride.getStartPickupLocation()==null?optionalRide.get().getStartPickupLocation():ride.getStartPickupLocation());
            rideUpdate.setEndDate(ride.getEndDate()==null?optionalRide.get().getEndDate():ride.getEndDate());
            rideUpdate.setEndPickupAddress(ride.getEndPickupAddress()==null?optionalRide.get().getEndPickupAddress():ride.getEndPickupAddress());
            rideUpdate.setEndPickupLocation(ride.getEndPickupLocation()==null?optionalRide.get().getEndPickupLocation():ride.getEndPickupLocation());
            rideUpdate.setCountryName(ride.getCountryName()==null?optionalRide.get().getCountryName():ride.getCountryName());
            rideUpdate.setCityName(ride.getCityName()==null?optionalRide.get().getCityName():ride.getCityName());
            rideUpdate.setPassengerFirstName(ride.getPassengerFirstName()==null?optionalRide.get().getPassengerFirstName():ride.getPassengerFirstName());
            rideUpdate.setPassengerLastName(ride.getPassengerLastName()==null?optionalRide.get().getPassengerLastName():ride.getPassengerLastName());
            rideUpdate.setDriverFirstName(ride.getDriverFirstName()==null?optionalRide.get().getDriverFirstName():ride.getDriverFirstName());
            rideUpdate.setDriverLastName(ride.getDriverLastName()==null?optionalRide.get().getDriverLastName():ride.getDriverLastName());
            rideUpdate.setCarPlate(ride.getCarPlate()==null?optionalRide.get().getCarPlate():ride.getCarPlate());
            rideUpdate.setStatus(ride.getStatus()==null?optionalRide.get().getStatus():ride.getStatus());
            rideUpdate.setCheckCode(ride.getCheckCode()==null?optionalRide.get().getCheckCode():ride.getCheckCode());
            rideUpdate.setCreatedAt(ride.getCreatedAt()==null?optionalRide.get().getCreatedAt():ride.getCreatedAt());
            rideUpdate.setUpdatedAt(ride.getUpdatedAt()==null?optionalRide.get().getUpdatedAt():ride.getUpdatedAt());
            rideUpdate.setPrice(ride.getPrice()==null?optionalRide.get().getPrice() : ride.getPrice());
            rideUpdate.setDriverLocation(ride.getDriverLocation()==null?optionalRide.get().getDriverLocation():ride.getDriverLocation());
            this.rideRepository.save(rideUpdate);
            return rideUpdate;
        }else {
            throw new Exception("Registro no encontrado con id "+id);
        }

    }

    @Override
    public Integer totalTrips() {
        return this.rideRepository.totalTrips();
    }

    @Override
    public Integer totalTripsCity(String city) {
        return this.rideRepository.totalTripsCity(city);
    }

    @Override
    public Integer totalTripsCoutry(String country) {
        return this.rideRepository.totalTripsCountry(country);
    }

    @Override
    public List<Ride> currentTrips() {
        return this.rideRepository.currentTrips();
    }
}
