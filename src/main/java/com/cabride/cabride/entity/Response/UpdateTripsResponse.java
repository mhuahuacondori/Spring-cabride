package com.cabride.cabride.entity.Response;

import com.cabride.cabride.entity.Ride;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTripsResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private RideResponse updateTripsResponse;

}
