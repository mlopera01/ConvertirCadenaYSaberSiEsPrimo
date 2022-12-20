package com.example.numerosYCadenas.controller;

import com.example.numerosYCadenas.service.ConversorCadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/convertir-cadena" )

public class ConversorCadenaController {
    private final ConversorCadenaService cadenaCaracterService;


    public ConversorCadenaController(@Autowired ConversorCadenaService cadenaCaracterService) {
        this.cadenaCaracterService = cadenaCaracterService;
    }

    @PostMapping //create
    @ResponseBody
    public ResponseEntity<ConversorCadenaResponse> calcularCadena(@RequestBody ConversorCadenaRequest cadena) {
        return ResponseEntity.ok(cadenaCaracterService.ConvertirCadena(cadena));
    }
}
