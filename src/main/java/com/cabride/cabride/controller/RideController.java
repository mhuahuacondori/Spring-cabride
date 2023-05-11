package com.cabride.cabride.controller;

import com.cabride.cabride.common.CastingMapper;
import com.cabride.cabride.common.Constantes;
import com.cabride.cabride.common.PropertiesExternos;
import com.cabride.cabride.common.Util;
import com.cabride.cabride.entity.*;
import com.cabride.cabride.entity.Response.*;
import com.cabride.cabride.service.RideService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constantes.PATH)
@Slf4j
@RequiredArgsConstructor
public class RideController {
    @Autowired
    RideService rideService;
    @Autowired
    private PropertiesExternos prop;

    @GetMapping(Constantes.PATH_TOTAL_TRIPS)
    public TripsResponse totalTrips()throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_UNO);
        TripsResponse tripsResponse = new TripsResponse();
        AuditResponse auditResponse =new AuditResponse();
        CountResponse countResponse = new CountResponse();

        try {
            countResponse.setTotal(this.rideService.totalTrips());
            auditResponse.setCodRespuesta(prop.idf0Cod);
            auditResponse.setMsjRespuesta(prop.idf0Msj);
            countResponse.setAuditResponse(auditResponse);
            tripsResponse.setTripsResponse(countResponse);
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            countResponse.setAuditResponse(auditResponse);
            tripsResponse.setTripsResponse(countResponse);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(tripsResponse);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_UNO);
        }
        return tripsResponse;
    }

    @GetMapping(Constantes.PATH_REQ_CITY)
    public TripsCityResponse totalTripsCity(@PathVariable(Constantes.REQ_CITY) String city) throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_DOS);
        TripsCityResponse tripsCityResponse = new TripsCityResponse();
        AuditResponse auditResponse =new AuditResponse();
        CountResponse countResponse = new CountResponse();
        try {
            log.info(Constantes.SEPARADOR_DOS_LLAVES,  Constantes.INPUT,  city);
            countResponse.setTotal(this.rideService.totalTripsCity(city));
            auditResponse.setCodRespuesta(prop.idf0Cod);
            auditResponse.setMsjRespuesta(prop.idf0Msj);
            countResponse.setAuditResponse(auditResponse);
            tripsCityResponse.setTripsCityResponse(countResponse);
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            countResponse.setAuditResponse(auditResponse);
            tripsCityResponse.setTripsCityResponse(countResponse);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(tripsCityResponse);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_DOS);
        }
        return tripsCityResponse;
    }
    @GetMapping(Constantes.PATH_REQ_COUNTRY)
    public TripsCoutryResponse totalTripsCoutry(@PathVariable(Constantes.REQ_COUNTRY) String country) throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_TRES);
        TripsCoutryResponse tripsCoutryResponse = new TripsCoutryResponse();
        AuditResponse auditResponse =new AuditResponse();
        CountResponse response = new CountResponse();
        try {
            log.info(Constantes.SEPARADOR_DOS_LLAVES,  Constantes.INPUT,  country);
            response.setTotal(this.rideService.totalTripsCoutry(country));
            auditResponse.setCodRespuesta(prop.idf0Cod);
            auditResponse.setMsjRespuesta(prop.idf0Msj);
            response.setAuditResponse(auditResponse);
            tripsCoutryResponse.setTripsCountryResponse(response);
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            response.setAuditResponse(auditResponse);
            tripsCoutryResponse.setTripsCountryResponse(response);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(tripsCoutryResponse);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_TRES);
        }
        return tripsCoutryResponse;
    }
    @PostMapping(Constantes.PATH_SAVE_TRIPS)
    public SaveTripsResponse save(@RequestBody Ride request)throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_CUATRO);
        SaveTripsResponse response = new SaveTripsResponse();
        AuditResponse auditResponse =new AuditResponse();
        try {
            String requestPrint = Util.printPrettyJSONString(request);
            log.info(Constantes.SEPARADOR_UNA_LLAVES,  Constantes.PARAMETROS_ENTRADA);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.REQUEST_BODY, Constantes.SALTO_LINEA, requestPrint);
            BodyResponse bodyResponseValidacion = (BodyResponse) CastingMapper.validParamsInput(request);
            if (Constantes.ZERO.equals(bodyResponseValidacion.getCodigoRespuesta())) {
                this.rideService.save(request);
                auditResponse.setCodRespuesta(prop.idf0Cod);
                auditResponse.setMsjRespuesta(prop.idf0Msj);
                response.setAuditResponse(auditResponse);
            }else {
                auditResponse.setCodRespuesta(prop.idt1Cod);
                auditResponse.setMsjRespuesta(String.format(prop.idt1Msj, Constantes.VALIDACION_REQUEST, bodyResponseValidacion.getMensajeError()));
                response.setAuditResponse(auditResponse);
            }
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            response.setAuditResponse(auditResponse);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(response);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_CUATRO);
        }
        return response;
    }
    @PutMapping(Constantes.PATH_REQ_ID)
    public UpdateTripsResponse update(@PathVariable(Constantes.REQ_ID) Long id,@RequestBody Ride ride) throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_CINCO);
        UpdateTripsResponse updateTripsResponse = new UpdateTripsResponse();
        AuditResponse auditResponse =new AuditResponse();
        RideResponse rideResponse = new RideResponse();
        try {
            String requestPrint = Util.printPrettyJSONString(ride);
            log.info(Constantes.SEPARADOR_UNA_LLAVES,  Constantes.PARAMETROS_ENTRADA);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.REQUEST_BODY, Constantes.SALTO_LINEA, requestPrint);
            ArrayList<Ride> rideArrayList = new ArrayList<>();
            rideArrayList.add(this.rideService.update(id,ride));
            auditResponse.setCodRespuesta(prop.idf0Cod);
            auditResponse.setMsjRespuesta(prop.idf0Msj);
            rideResponse.setAuditResponse(auditResponse);
            rideResponse.setTrips(rideArrayList);
            updateTripsResponse.setUpdateTripsResponse(rideResponse);
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            rideResponse.setAuditResponse(auditResponse);
            updateTripsResponse.setUpdateTripsResponse(rideResponse);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(updateTripsResponse);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_CINCO);
        }
        return updateTripsResponse;

    }

    @GetMapping(Constantes.PATH_CURRENT_TRIPS)
    public CurrentTripsResponse currentTrips()throws JsonProcessingException {
        Util.inicioMetodo(Constantes.METODO_SEIS);
        CurrentTripsResponse currentTripsResponse = new CurrentTripsResponse();
        AuditResponse auditResponse =new AuditResponse();
        RideResponse rideResponse = new RideResponse();
        try {
            List<Ride> rideList = this.rideService.currentTrips();
            auditResponse.setCodRespuesta(prop.idf0Cod);
            auditResponse.setMsjRespuesta(prop.idf0Msj);
            rideResponse.setAuditResponse(auditResponse);
            rideResponse.setTrips(rideList);
            currentTripsResponse.setCurrentTripsResponse(rideResponse);
        }catch (Exception e){
            auditResponse.setCodRespuesta(prop.idt1Cod);
            auditResponse.setMsjRespuesta(e.getLocalizedMessage());
            rideResponse.setAuditResponse(auditResponse);
            currentTripsResponse.setCurrentTripsResponse(rideResponse);
            log.error(Constantes.SEPARADOR_TRES_LLAVES, Constantes.ESPACIO, Constantes.ERROR_EXCEPTION,e.getMessage(),e);
        }finally {
            String responsePrint = Util.printPrettyJSONString(currentTripsResponse);
            log.info(Constantes.SEPARADOR_TRES_LLAVES,  Constantes.PARAMETROS_SALIDA, Constantes.SALTO_LINEA, responsePrint);
            Util.finMetodo(Constantes.METODO_SEIS);
        }
        return currentTripsResponse;
    }


}
