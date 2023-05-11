package com.cabride.cabride.entity.Response;

import com.cabride.cabride.entity.Ride;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RideResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private AuditResponse auditResponse;
    private List<Ride> trips;

}
