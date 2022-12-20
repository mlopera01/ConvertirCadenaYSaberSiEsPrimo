package com.example.numerosYCadenas.controller;

import com.example.numerosYCadenas.service.ConversorCadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/cadenas" )


public class CalculoVocalesYConsonantesController {
    private final ConversorCadenaService conversorCadenaService;

    public CalculoVocalesYConsonantesController(@Autowired ConversorCadenaService conversorCadenaService)
    {
        this.conversorCadenaService = conversorCadenaService;
    }
    @PostMapping
    public ResponseEntity<CalcularVocalesYConsonantesResponse> solucion (@RequestBody CalcularVocalesyConsonantesRequest cadena){
        return ResponseEntity.ok(conversorCadenaService.calcularVocalesYConsonantes(cadena));
    }
}
