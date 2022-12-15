package com.example.numerosYCadenas.service.impl;

import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoRequest;
import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoResponse;
import com.example.numerosYCadenas.service.NumeroService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ValidadorNumeroServiceImpl implements NumeroService {
    @Override
    public ValidadorNumeroPrimoResponse realizarCalculo(ValidadorNumeroPrimoRequest numeroRequest) {
        List<Integer> lista = numeroRequest.getListaRecibida();
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < lista.size(); i++) {
            Integer value = lista.get(i);
            if(value <= 0 || value > 100){
                throw new IllegalArgumentException("La lista tiene numeros menores que 0 ó mayores que 100");
            }
            //map.put(value, isPrime(value)? "Primo" : "No Primo");
            if (isPrime(value)) {
                map.put(value, "Primo");
            } else {
                map.put(value, "No Primo");
            }
        }
        ValidadorNumeroPrimoResponse nr = new ValidadorNumeroPrimoResponse();
        StringBuilder devolver = new StringBuilder();
        for(int key : map.keySet()) {
            if(devolver.length() > 0) {
                devolver.append(", ");
            }
            devolver.append(key).append(" ").append(map.get(key));
        }
        nr.setObjetoDevuelto(devolver.toString());
        return nr;
    }

    private boolean isPrime(int number){
        if(number <2) {
            return false;
        }

        for(int j=2;j<number;j++){
            if(number%j==0){
                return false;
            }
        }
        return true;
    }
}
