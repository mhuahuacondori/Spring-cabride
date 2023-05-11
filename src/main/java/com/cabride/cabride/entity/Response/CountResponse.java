package com.cabride.cabride.entity.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private AuditResponse auditResponse;
    private Integer total;
}
