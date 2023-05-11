package com.cabride.cabride.common;

import com.cabride.cabride.entity.Response.BodyResponse;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Slf4j
public class CastingMapper {

    private static final Validator validator;

    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static Object validParamsInput( Object beanRequest) {

        BodyResponse response = new BodyResponse();

        log.info(Constantes.SEPARADOR_UNA_LLAVES,  "Evaluando Body");

        String body = beanHaveViolations(beanRequest);
        if (body != null) {
            log.info(Constantes.SEPARADOR_UNA_LLAVES, "Body no cumple con parametros obligatorios");
            response.setMensajeError("Datos de Body incompletos, VERIFICAR: " + body);
            response.setCodigoRespuesta(Constantes.UNO);
            return response;
        }

        log.info(Constantes.SEPARADOR_UNA_LLAVES, "Validacion correcta de Body");
        response.setCodigoRespuesta(Constantes.ZERO);
        return response;
    }

    private static String beanHaveViolations(Object object) {
        return validator.validate(object).stream().findFirst().map(e -> e.getPropertyPath() + " - " + e.getMessage())
                .orElse(null);
    }
}
