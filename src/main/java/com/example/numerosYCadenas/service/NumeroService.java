package com.example.numerosYCadenas.service;

import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoRequest;
import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoResponse;

public interface NumeroService {
    ValidadorNumeroPrimoResponse realizarCalculo(ValidadorNumeroPrimoRequest numeroRequest);
}
