package br.com.aula;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.RepeatedTest;

class CalculadoraTest {
	Calculadora calc;
	TestInfo testInfo;
	TestReporter testReport;
	
	@BeforeEach
	void init (TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReport = testReporter;
		calc = new Calculadora();
	}
	
	@Nested
	@DisplayName("Cenario001 - Testa Soma")
	class soma{
		
		@Test
		@DisplayName("CT001.01 - Testa Soma Valores Positivos")
		void testSomaPositivos() {
			testReport.publishEntry("Executando " + testInfo.getDisplayName());
			double valorEsperado = 12.0;
			double valorAtual = calc.soma(7.0, 5.0);
			
			assertEquals(valorEsperado, valorAtual, "Falha ao executar a soma");
		}
		
		@Test
		@DisplayName("CT001.02 - Testa Soma Valores Negativos")
		void testSomaNegativos() {
			testReport.publishEntry("Executando " + testInfo.getDisplayName());
			double valorEsperado = -12.0;
			double valorAtual = calc.soma(-7.0, -5.0);
			
			assertEquals(valorEsperado, valorAtual, "Falha ao executar a soma");
		}		
		
	}
	
	@RepeatedTest(3)
	@DisplayName("CT003 - Testa Multiplicação Varios valores")
	void testMultiplicaVariosValores() {
		testReport.publishEntry("Executando " + testInfo.getDisplayName());
		assertAll(
			() -> assertEquals(-4.0, calc.multiplicacao(-2.0, 2.0)),
			() -> assertEquals(12.0, calc.multiplicacao(4.0, 3.0)),
			() -> assertEquals(-21.0, calc.multiplicacao(7.0, -3.0)),
			() -> assertEquals(0.0, calc.multiplicacao(7.0, 0.0))
		);		
	}
	
	
	@Nested
	@DisplayName("CT004 - Testa Divisao")
	class divide{
		
		@Test
		@DisplayName("CT004.01 - Testa Divisão Valores diferente de zero")
		void testDivide001() {
			testReport.publishEntry("Executando " + testInfo.getDisplayName());
			double valorEsperado = 6;
			double valorAtual = calc.divisao(30, 5);
			
			assertEquals(valorEsperado, valorAtual, "Falha ao executar a soma");
		}
		
		@Test
		@Disabled
		@DisplayName("CT004.02 - Testa Divisão com Zero")
		void testDivide002() {						
			assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0), "Impossivel dividir por zero");
		}
		
	}

}
