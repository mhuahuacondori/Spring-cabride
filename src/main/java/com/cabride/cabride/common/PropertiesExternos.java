package com.cabride.cabride.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesExternos {
    @Value("${idt1.cod}")
    public String idt1Cod;
    @Value("${idt1.msj}")
    public String idt1Msj;


    @Value("${idf0.cod}")
    public String idf0Cod;
    @Value("${idf0.msj}")
    public String idf0Msj;
    @Value("${idf1.cod}")
    public String idf1Cod;
    @Value("${idf1.msj}")
    public String idf1Msj;
    @Value("${idf2.cod}")
    public String idf2Cod;
    @Value("${idf2.msj}")
    public String idf2Msj;
}
