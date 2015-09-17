package carrinhoDeCompra;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class ItemDoCarrinhoTeste {

	private Produto geladeira;

	@Before
	public void inicializar() throws Exception {
		geladeira = new Produto("Geladeira", 1200d);
	}
	
	@Test
	public void deve_calcular_valor_total() throws Exception {
		double totalEsperado = 2400d;
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(geladeira, 2);
		
		assertEquals(totalEsperado, itemDoCarrinho.getValorTotal(), 0.001);
	}
}
