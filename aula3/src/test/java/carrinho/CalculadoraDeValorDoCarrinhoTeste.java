package carrinho;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class CalculadoraDeValorDoCarrinhoTeste {

	@Test
	public void deve_calcular_o_valor_do_carrinho_com_o_valor_do_frete() throws Exception {
		double valorTotalEsperado = 114.50d;
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		Produto produto = new Produto("Fone", 100d);
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(produto , 1);
		carrinho.adicionar(itemDoCarrinho);
		
		FreteService freteService = Mockito.mock(FreteServiceImpl.class);
		Mockito.when(freteService.calcular()).thenReturn(14.50d);
		
		double valorTotalRetornado = carrinho.getValorComFrete(freteService);
		
		assertThat(valorTotalRetornado, is(valorTotalEsperado));
	}
}
