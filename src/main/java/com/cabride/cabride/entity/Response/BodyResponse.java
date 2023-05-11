package com.cabride.cabride.entity.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BodyResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensajeError;
    private String codigoRespuesta;
    private String mensajeRespuesta;
}
