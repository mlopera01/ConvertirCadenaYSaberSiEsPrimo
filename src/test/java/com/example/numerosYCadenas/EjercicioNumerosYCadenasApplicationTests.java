package com.example.numerosYCadenas;

import com.example.numerosYCadenas.controller.ConversorCadenaRequest;
import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoRequest;
import com.example.numerosYCadenas.controller.ValidadorNumeroPrimoResponse;
import com.example.numerosYCadenas.service.ConversorCadenaService;
import com.example.numerosYCadenas.service.NumeroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EjercicioNumerosYCadenasApplicationTests {

	@Autowired
	NumeroService numeroService;

	@Autowired
	ConversorCadenaService cadenaAConvertirService;

	@Test
	void testValorDevuelto_WhenCadenaEsvacía_ThenError() {
		ConversorCadenaRequest cadenaAConvertirRequest = new ConversorCadenaRequest();
		cadenaAConvertirRequest.setCadena("");
		cadenaAConvertirRequest.setValorHasta(0);
		System.out.println("Por testValorDevuelto_WhenCadenaEsVacía_ThenError: " + cadenaAConvertirRequest);
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> cadenaAConvertirService.realizarCalculo(cadenaAConvertirRequest));
	}

	@Test
	void testValorDevuelto_WhenCadenaEsNoVacía_ThenOk() {
		ConversorCadenaRequest cadenaAConvertirRequest = new ConversorCadenaRequest();
		cadenaAConvertirRequest.setCadena("Hola es un gusto servirte");
		cadenaAConvertirRequest.setValorHasta(5);
		System.out.println("Por testValorDevuelto_WhenCadenaEsNoVacía_ThenOk: " + cadenaAConvertirRequest);
		Assertions.assertEquals("Hola ,es un ,gusto ,servirte ",
				cadenaAConvertirService.realizarCalculo(cadenaAConvertirRequest).getCadenaCovertida());
	}

	@Test
	void testValorDevuelto_WhenCadenaTieneSoloUnaFraseMayorAValorHasta_ThenOk() {
		ConversorCadenaRequest cadenaAConvertirRequest = new ConversorCadenaRequest();
		cadenaAConvertirRequest.setCadena("Esternocleidomastoideo");
		cadenaAConvertirRequest.setValorHasta(10);
		System.out.println("Por testValorDevuelto_WhenCadenaEsNoVacía_ThenOk: " + cadenaAConvertirRequest);
		Assertions.assertEquals("Esternocleidomastoideo ",
				cadenaAConvertirService.realizarCalculo(cadenaAConvertirRequest).getCadenaCovertida());
	}

	@Test
	void testValorEnLista_WhenNumeroIsMenorQueZero_ThenError() {
		ValidadorNumeroPrimoRequest nr = new ValidadorNumeroPrimoRequest();
		List<Integer> lista = new ArrayList<>();
		lista.add(5);
		lista.add(-1);
		lista.add(50);
		lista.add(101);
		nr.setListaRecibida(lista);
		System.out.println("Por testValorEnLista_WhenNumeroIsMenorQueZero_ThenError: " + lista);
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> numeroService.realizarCalculo(nr));
	}

	@Test
	void testPrimo_WhenNumeroIsPrimo_ThenOk() {
		ValidadorNumeroPrimoRequest nr = new ValidadorNumeroPrimoRequest();
		List<Integer> lista = new ArrayList<>();
		lista.add(5);
		nr.setListaRecibida(lista);
		ValidadorNumeroPrimoResponse numeroResponse = new ValidadorNumeroPrimoResponse();
		numeroResponse = numeroService.realizarCalculo(nr);
		String a = numeroResponse.getObjetoDevuelto();
		System.out.println("Por testPrimo_WhenNumeroIsPrimo_ThenOk: " + a);
		Assertions.assertEquals("5 Primo", a);

	}
	@Test
	void testNoPrimo_WhenNumeroIsNotPrimo_ThenOk() {
		ValidadorNumeroPrimoRequest nr = new ValidadorNumeroPrimoRequest();
		List<Integer> lista = new ArrayList<>();
		lista.add(100);
		nr.setListaRecibida(lista);
		ValidadorNumeroPrimoResponse numeroResponse = new ValidadorNumeroPrimoResponse();
		numeroResponse = numeroService.realizarCalculo(nr);
		String a = numeroResponse.getObjetoDevuelto();
		System.out.println("Por testNoPrimo_WhenNumeroIsNotPrimo_ThenOk: " + a);
		Assertions.assertEquals("100 No Primo", a);

	}
	@Test
	void testNoPrimoYPrimo_WhenBoth_ThenOk() {
		List<Integer> lista = new ArrayList<>();
		lista.add(100);
		lista.add(4);

		ValidadorNumeroPrimoRequest nr = new ValidadorNumeroPrimoRequest();
		nr.setListaRecibida(lista);
		ValidadorNumeroPrimoResponse numeroResponse = new ValidadorNumeroPrimoResponse();
		numeroResponse = numeroService.realizarCalculo(nr);

		String a = numeroResponse.getObjetoDevuelto();
		System.out.println("Por testNoPrimoYPrimo_WhenBoth_ThenOk: " + a);
		Assertions.assertEquals("4 No Primo, 100 No Primo", a);
	}

}
