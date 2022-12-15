package com.example.numerosYCadenas.service.impl;

import com.example.numerosYCadenas.controller.ConversorCadenaRequest;
import com.example.numerosYCadenas.controller.ConversorCadenaResponse;
import com.example.numerosYCadenas.service.ConversorCadenaService;
import org.springframework.stereotype.Service;

@Service
public class ConversorCadenaImpl implements ConversorCadenaService {
    @Override
    public ConversorCadenaResponse realizarCalculo(ConversorCadenaRequest cadenaCaracter) {
        String cadena = cadenaCaracter.getCadena();
        int valorHasta = cadenaCaracter.getValorHasta();

        if (cadena.isEmpty()) {
            //cadenaADevolver.append("Cadena vacía");
            //return cadenaADevolver.toString();
            throw new IllegalArgumentException("La cadena ingresada es vacía");
        }
        String cadenaRecibida = validacionCadena(cadena, valorHasta);
        ConversorCadenaResponse cadenaAConvertirResponse = new ConversorCadenaResponse();
        cadenaAConvertirResponse.setCadenaRecibida(cadena);
        cadenaAConvertirResponse.setCadenaCovertida(cadenaRecibida);
        cadenaAConvertirResponse.setValorHasta(valorHasta);
        return cadenaAConvertirResponse;
    }

    public String validacionCadena(String cadena, int valorHasta) {
        StringBuilder cadenaADevolver = new StringBuilder();
        StringBuilder cadenaTemporal = new StringBuilder();
        // Este es un arreglo que solo voy a recorrer podría ser una lista
        String[] frase = cadena.split(" ");
        //System.out.println("Frase: " +frase.toString());
        //System.out.println("Cadena: " +cadena);
        for (String x : frase) {
            // Acá se adiciona a la cadena mayor la cadena temporal cuando la primera vez la palabra
            // es mayor al valorHasta o cuando en medio del proceso se va a sobre pasar
            if (cadenaTemporal.length() + x.length() > valorHasta) {
                cadenaADevolver.append(cadenaTemporal);
                if (cadenaADevolver.length() > 0) {
                    cadenaADevolver.append(",");
                }
                cadenaTemporal.setLength(0);
            }
            // Acá se va adicionando a la cadena temporal los distintos pedacitos que se van tomando
            // y separando por espacios
            cadenaTemporal.append(x);
            // La siguiente instrucción sirve para agregar espacio al final de cada frase agregada
            cadenaTemporal.append(" ");
        }
        cadenaADevolver.append(cadenaTemporal.toString());
        return cadenaADevolver.toString();
    }
}


