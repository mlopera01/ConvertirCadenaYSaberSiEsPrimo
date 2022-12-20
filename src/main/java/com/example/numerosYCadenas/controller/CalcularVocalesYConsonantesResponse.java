package com.example.numerosYCadenas.controller;

import lombok.Data;


@Data
public class CalcularVocalesYConsonantesResponse {
    private String cadenaRecibida;
    private int numeroVocales;
    private int numeroConsonantes;
    private String cadenaCovertida;
}
