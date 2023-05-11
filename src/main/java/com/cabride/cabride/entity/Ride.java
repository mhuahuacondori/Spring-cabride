package com.cabride.cabride.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="ride", schema="trips")
public class Ride implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "start_pickup_address")
    private String startPickupAddress;
    @Column(name = "start_pickup_location")
    private String startPickupLocation;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "end_pickup_address")
    private String endPickupAddress;
    @Column(name = "end_pickup_location")
    private String endPickupLocation;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "passenger_first_name")
    private String passengerFirstName;
    @Column(name = "passenger_last_name")
    private String passengerLastName;
    @Column(name = "driver_first_name")
    private String driverFirstName;
    @Column(name = "driver_last_name")
    private String driverLastName;
    @Column(name = "car_plate")
    private String carPlate;
    @Column(name = "status")
    private String status;
    @Column(name = "check_code")
    private String checkCode;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "price")
    private Float price;
    @Column(name = "driver_location")
    private String driverLocation;
}
