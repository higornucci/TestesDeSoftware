package br.com.htcursos.comissao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import br.com.htcursos.comissao.CalculoPorcentagemDaVenda;

public class TestaCalculoPorcentagemDeVenda {

	@Test
	public void deve_retornar_a_comissao_de_uma_unica_venda() {

		Double valorDaVenda = 10000.00;
		Double valorDaComissaoEsperado = 500.00;

		CalculoPorcentagemDaVenda v = new CalculoPorcentagemDaVenda();
		Double valorRetornado = v.calcularPorcentagemDeComissao(valorDaVenda);

		assertThat(valorRetornado, equalTo(valorDaComissaoEsperado));
	}

	@Test
	public void deve_retornar_a_comissao_de_uma_unica_venda_quando_valor_da_venda_for_menor_10000() {

		Double valorDaVenda = 9000.00;
		Double valorDaComissaoEsperado = 450.00;

		CalculoPorcentagemDaVenda v = new CalculoPorcentagemDaVenda();
		Double valorRetornado = v.calcularPorcentagemDeComissao(valorDaVenda);

		assertThat(valorDaComissaoEsperado, is(valorRetornado));
	}
	
	@Test
	public void deve_retornar_a_comissao_de_uma_unica_venda_quando_valor_da_venda_for_maior_10000() {

		Double valorDaVenda = 20000.00;
		Double valorDaComissaoEsperado = 1200.00;

		CalculoPorcentagemDaVenda v = new CalculoPorcentagemDaVenda();
		Double valorRetornado = v.calcularPorcentagemDeComissao(valorDaVenda);

		assertEquals(valorDaComissaoEsperado, valorRetornado, 0.001);
	}
	
	@Test
	public void ah_empresa_nao_deve_levar_prejuizo() {

		Double valorDaVenda = 5467.77;
		Double valorDaComissaoEsperado = 273.38;

		CalculoPorcentagemDaVenda v = new CalculoPorcentagemDaVenda();
		Double valorRetornado = v.calcularPorcentagemDeComissao(valorDaVenda);

		assertEquals(valorDaComissaoEsperado, valorRetornado, 0.001);
	}
	
	@Test
	public void a_empresa_nao_deve_levar_prejuizo_quando_comissao_for_seis_porcento() throws Exception {
		Double valorDaVenda = 15467.77;
		Double valorDaComissaoEsperado = 928.06;

		CalculoPorcentagemDaVenda v = new CalculoPorcentagemDaVenda();
		Double valorRetornado = v.calcularPorcentagemDeComissao(valorDaVenda);

		assertEquals(valorDaComissaoEsperado, valorRetornado, 0.001);
	}
}
