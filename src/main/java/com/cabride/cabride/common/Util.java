package com.cabride.cabride.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Slf4j
@Component
public class Util {

    public static DateFormat getLocalFormat() {
        DateFormat dateFormat = new SimpleDateFormat(Constantes.FORMATO_FECHA_CABECERA);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat;
    }

    public static String printPrettyJSONString(Object o) throws JsonProcessingException {
        return new ObjectMapper().setDateFormat(Util.getLocalFormat())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
                .writeValueAsString(o);
    }

    public static String printJSONString(Object o) throws JsonProcessingException {
        return new ObjectMapper().setDateFormat(Util.getLocalFormat())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
    }

    public static void inicioMetodo(String metodo) {
        log.info(Constantes.SEPARADOR_01);
        log.info(Constantes.CORCHETE_IZQUIERDO + Constantes.INICIO_METODO + metodo + Constantes.CORCHETE_DERECHO);
    }

    public static void finMetodo(String metodo) {
        log.info(Constantes.CORCHETE_IZQUIERDO + Constantes.FIN_METODO + metodo + Constantes.CORCHETE_DERECHO);
        log.info(Constantes.SEPARADOR_01);
    }
}
