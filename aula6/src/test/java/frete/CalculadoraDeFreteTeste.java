package frete;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.htcursos.frete.CalculadoraDeFrete;
import br.com.htcursos.frete.ServicoDeFrete;
import br.com.htcursos.frete.ServicoDeFreteImpl;
import br.com.htcursos.frete.ServicoDeFreteIndisponivel;

public class CalculadoraDeFreteTeste {

	private static final String CEP_ORIGEM = "79750000";
	private static final String CEP_DESTINO = "79800000";;
	private ServicoDeFrete servicoDeFrete;
	private CalculadoraDeFrete calculadora;

	@Before
	public void init() {
		servicoDeFrete = mock(ServicoDeFreteImpl.class);
		calculadora = new CalculadoraDeFrete(servicoDeFrete, CEP_ORIGEM);
	}

	@Test
	public void deve_retornar_o_valor_doc_frete() throws Exception {
		double valorDoFreteEsperado = 12.45d;

		when(servicoDeFrete.calcularFretePara(CEP_ORIGEM, CEP_DESTINO)).thenReturn(valorDoFreteEsperado);

		double valorDoFreteRetornado = calculadora.calcularFretePara(CEP_DESTINO);

		assertEquals(valorDoFreteEsperado, valorDoFreteRetornado, 0.001);
	}

	@Test(expected = ServicoDeFreteIndisponivel.class)
	public void deve_avisar_quando_o_servi�o_de_frete_estiver_indisponivel() throws Exception {
		when(servicoDeFrete.calcularFretePara(CEP_ORIGEM, CEP_DESTINO)).thenThrow(new ServicoDeFreteIndisponivel());

		calculadora.calcularFretePara(CEP_DESTINO);
	}
	
	@Test(expected = CepIncorreto.class)
	public void deve_avisar_quando_o_cep_estiver_incorreto() throws Exception {
		when(servicoDeFrete.calcularFretePara(CEP_ORIGEM, "79567")).thenThrow(new CepIncorreto());
		
		calculadora.calcularFretePara("79567");
	}

}