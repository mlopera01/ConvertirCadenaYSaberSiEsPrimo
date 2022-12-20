package com.example.numerosYCadenas.service.impl;

import com.example.numerosYCadenas.controller.CalcularVocalesyConsonantesRequest;
import com.example.numerosYCadenas.controller.ConversorCadenaRequest;
import com.example.numerosYCadenas.controller.CalcularVocalesYConsonantesResponse;
import com.example.numerosYCadenas.controller.ConversorCadenaResponse;
import com.example.numerosYCadenas.service.ConversorCadenaService;
import org.springframework.stereotype.Service;

@Service
public class CalculoVocalesYConsonantesImpl implements ConversorCadenaService {

    @Override
    public ConversorCadenaResponse ConvertirCadena(ConversorCadenaRequest cadenaCaracter) {
        String cadena = cadenaCaracter.getCadena();
        int valorHasta = cadenaCaracter.getValorHasta();

        if (cadena.isEmpty()) {
            //cadenaADevolver.append("Cadena vacía");
            //return cadenaADevolver.toString();
            throw new IllegalArgumentException("La cadena ingresada es vacía");
        }
        String cadenaRecibida = validacionCadena(cadena, valorHasta);
        ConversorCadenaResponse conversorCadenaResponse = new ConversorCadenaResponse();
        conversorCadenaResponse.setCadenaRecibida(cadena);
        conversorCadenaResponse.setCadenaCovertida(cadenaRecibida);
        conversorCadenaResponse.setValorHasta(valorHasta);
        return conversorCadenaResponse;
    }



    public String validacionCadena(String cadena, int valorHasta) {
        StringBuilder cadenaADevolver = new StringBuilder();
        StringBuilder cadenaTemporal = new StringBuilder();
        // Este es un arreglo que solo voy a recorrer podría ser una lista
        String[] frase = cadena.split(" ");
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



    @Override
    public CalcularVocalesYConsonantesResponse calcularVocalesYConsonantes(CalcularVocalesyConsonantesRequest cadena) {
        String cadena1 = cadena.getCadena();
        return validarVocalesYConsonantes(cadena1);
    }


    public CalcularVocalesYConsonantesResponse validarVocalesYConsonantes(String cadena) {
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        String ultimaVocal="";
        String cadenaReemplazada = cadena.toLowerCase(); // Pasa la cadena a minúsculas

        for (int i = 0; i < cadenaReemplazada.length(); i++) {
            String x = String.valueOf(cadenaReemplazada.charAt(i));
            String y = x.toLowerCase();
            System.out.println("letra: " +y);
            if (y.equals("a") || y.equals("e") || y.equals("i") || y.equals("o") || y.equals("u")) {
                ultimaVocal = y;
                contadorVocales = contadorVocales+1;
                System.out.println("contadorVocales: " +contadorVocales);
                System.out.println("Ultima Vocal: " +ultimaVocal);


            } else {
                if (y.equals("b") || y.equals("c") || y.equals("d") || y.equals("f") || y.equals("g")
                        || y.equals("h") || y.equals("j") || y.equals("k") || y.equals("l") || y.equals("m")
                        || y.equals("n") || y.equals("s") || y.equals("t") || y.equals("v") || y.equals("w")
                        || y.equals("x") || y.equals("y") || y.equals("z") || y.equals("r") || y.equals("ñ") || y.equals("p")
                        || y.equals("q")) {
                    contadorConsonantes = contadorConsonantes+1;
                    System.out.println("contadorConsonantes: " +contadorConsonantes);

                }
            }
        }

        CalcularVocalesYConsonantesResponse conversorCadenaResponse = new CalcularVocalesYConsonantesResponse();
        conversorCadenaResponse.setCadenaRecibida(cadena);
        conversorCadenaResponse.setNumeroVocales(contadorVocales);
        conversorCadenaResponse.setNumeroConsonantes(contadorConsonantes);
        if(cadena.length()==0){
            String cadenaNueva = " Cadena ingresada está  vacía";
            conversorCadenaResponse.setCadenaCovertida(cadenaNueva);
            return conversorCadenaResponse;
        }
        conversorCadenaResponse.setCadenaCovertida(reemplazarValoresEnCadena(cadenaReemplazada, ultimaVocal));
        return conversorCadenaResponse;
    }

    public String reemplazarValoresEnCadena(String cadenaNueva, String ultimaVocal) {
        return (cadenaNueva.replaceAll("[aeiou]", ultimaVocal));
    }
}




