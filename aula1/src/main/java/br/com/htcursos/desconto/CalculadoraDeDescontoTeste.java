package br.com.htcursos.desconto;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraDeDescontoTeste {
	
	@Test
	public void deve_calcular_desconto_de_cinco_porcento() {
		double valorDaCompra = 120d;
		double valorComDescontoEsperado = 114d;
		
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		double valorComDescontoRetornado = calculadoraDeDesconto.calcularDescontoPara(valorDaCompra);
		
		assertEquals(valorComDescontoEsperado, valorComDescontoRetornado, 0.001);
	}
	
	@Test
	public void nao_deve_dar_desconto_para_compras_com_valor_baixo() {
		double valorDaCompra = 90d;
		double valorSemDescontoEsperado = 90d;
		
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		double valorSemDescontoRetornado = calculadoraDeDesconto.calcularDescontoPara(valorDaCompra);
		
		assertEquals(valorSemDescontoEsperado, valorSemDescontoRetornado, 0.001);
	}
	
	@Test
	public void nao_deve_dar_desconto_de_cinco_porcento_quando_eh_valor_limite() {
		double valorDaCompra = 100d;
		double valorSemDescontoEsperado = 100d;
		
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		double valorSemDescontoRetornado = calculadoraDeDesconto.calcularDescontoPara(valorDaCompra);
		
		assertEquals(valorSemDescontoEsperado, valorSemDescontoRetornado, 0.001);
	}
	
	@Test
	public void deve_dar_desconto_de_cinco_porcento_para_150_reais() throws Exception {
		double valorDaCompra = 150d;
		double valorComDescontoEsperado = 142.5d;
		
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		double valorComDescontoRetornado = calculadoraDeDesconto.calcularDescontoPara(valorDaCompra);
		
		assertEquals(valorComDescontoEsperado, valorComDescontoRetornado, 0.001);
	}
	
	@Test
	public void deve_dar_desconto_de_dez_porcento() throws Exception {
		double valorDaCompra = 160d;
		double valorComDescontoEsperado = 144d;
		
		CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
		double valorComDescontoRetornado = calculadoraDeDesconto.calcularDescontoPara(valorDaCompra);
		
		assertEquals(valorComDescontoEsperado, valorComDescontoRetornado, 0.001);
	}
}
