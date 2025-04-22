package com.ugb.miprimeraaplicacion;

import java.util.Base64;

public class utilidades {
    static String url_consulta = "http://192.168.223.165:5984/jonathan/_design/ever/_view/ever";
    static String url_mto = "http://192.168.223.165:5984/jonathan";
    static String user = "Jonathan";
    static String passwd = "Jonathan2025";
    static String credencialesCodificadas = Base64.getEncoder().encodeToString((user + ":" + passwd).getBytes());

    public String generarUnicoId() {
        return java.util.UUID.randomUUID().toString();
    }
}