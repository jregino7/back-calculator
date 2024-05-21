package com.calculator.Calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculator.Calculator.models.salida;
import com.calculator.Calculator.controllers.CalculatorControlador;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorApplicationTests {

	salida asserResult = new salida();

	CalculatorControlador controlador = new CalculatorControlador();

	@Test
	void textSuma() {
		salida localSalida=controlador.operar("28", "2", "suma");
		asserResult.setResultado(30);
		asserResult.setstado("ok");
		assertEquals(asserResult.getResultado(),localSalida.getResultado());
		assertEquals(asserResult.getStado(),localSalida.getStado());

	}

	@Test
	void textResta() {
		salida localSalida=controlador.operar("28", "2", "resta");
		asserResult.setResultado(26);
		asserResult.setstado("ok");
		assertEquals(asserResult.getResultado(),localSalida.getResultado());
		assertEquals(asserResult.getStado(),localSalida.getStado());

	}

	@Test
	void textMultiplicacion() {
		salida localSalida=controlador.operar("28", "2", "multiplicacion");
		asserResult.setResultado(56);
		asserResult.setstado("ok");
		assertEquals(asserResult.getResultado(),localSalida.getResultado());
		assertEquals(asserResult.getStado(),localSalida.getStado());

	}

	@Test
	void textDivision() {
		salida localSalida=controlador.operar("28", "2", "division");
		asserResult.setResultado(14);
		asserResult.setstado("ok");
		assertEquals(asserResult.getResultado(),localSalida.getResultado());
		assertEquals(asserResult.getStado(),localSalida.getStado());

	}


}
