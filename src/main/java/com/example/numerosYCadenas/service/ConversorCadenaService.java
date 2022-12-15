package com.example.numerosYCadenas.service;

import com.example.numerosYCadenas.controller.ConversorCadenaRequest;
import com.example.numerosYCadenas.controller.ConversorCadenaResponse;

public interface ConversorCadenaService {
    ConversorCadenaResponse realizarCalculo (ConversorCadenaRequest cadena);
}
