package com.example.numerosYCadenas.controller;

import com.example.numerosYCadenas.service.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/names_1a100" )

public class ValidadorNumeroPrimoController {

    private final NumeroService numeroService;


    public ValidadorNumeroPrimoController(@Autowired NumeroService numeroService) {
        this.numeroService = numeroService;
    }

    @PostMapping //create
    @ResponseBody
    public ResponseEntity<ValidadorNumeroPrimoResponse> calcular(@RequestBody ValidadorNumeroPrimoRequest valores) {
        return ResponseEntity.ok(numeroService.realizarCalculo(valores));
    }
}
