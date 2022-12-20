package com.example.numerosYCadenas.service;

import com.example.numerosYCadenas.controller.CalcularVocalesyConsonantesRequest;
import com.example.numerosYCadenas.controller.ConversorCadenaRequest;
import com.example.numerosYCadenas.controller.CalcularVocalesYConsonantesResponse;
import com.example.numerosYCadenas.controller.ConversorCadenaResponse;

public interface ConversorCadenaService {
    ConversorCadenaResponse ConvertirCadena (ConversorCadenaRequest cadena);
    CalcularVocalesYConsonantesResponse calcularVocalesYConsonantes (CalcularVocalesyConsonantesRequest cadena);

}
