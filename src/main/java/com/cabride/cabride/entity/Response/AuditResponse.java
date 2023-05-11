package com.cabride.cabride.entity.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuditResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codRespuesta;
    private String msjRespuesta;
}
