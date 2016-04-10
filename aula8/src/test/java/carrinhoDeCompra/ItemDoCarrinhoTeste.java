package carrinhoDeCompra;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class ItemDoCarrinhoTeste {

	private Produto geladeira;

	@BeforeMethod
	public void inicializar() throws Exception {
		geladeira = ProdutoBuilder.novo().criar();
	}
	
	@Test
	public void deve_calcular_valor_total() throws Exception {
		double totalEsperado = 2400d;
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(geladeira, 2);
		
		assertEquals(totalEsperado, itemDoCarrinho.getValorTotal(), 0.001);
	}
}
