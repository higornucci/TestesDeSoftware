package frete;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class CalculadoraDeFreteTeste {
	
	@Test
	public void deve_retornar_o_valor_doc_frete() throws Exception {
		double valorDoFreteEsperado = 12.45d;
		String cepDeOrigem = "79750000";
		String cepDeDestino = "79800000";
		
		ServicoDeFrete servicoDeFrete = Mockito.mock(ServicoDeFreteImpl.class);
		Mockito.when(servicoDeFrete.calcularFretePara(cepDeOrigem, cepDeDestino))
				.thenReturn(valorDoFreteEsperado);
		
		CalculadoraDeFrete calculadora = new CalculadoraDeFrete(servicoDeFrete, cepDeOrigem);
		double valorDoFreteRetornado = calculadora.calcularFretePara(cepDeDestino);
		
		assertEquals(valorDoFreteEsperado, valorDoFreteRetornado, 0.001);
	}
}
