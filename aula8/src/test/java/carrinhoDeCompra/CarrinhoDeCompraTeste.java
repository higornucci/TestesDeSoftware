package carrinhoDeCompra;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class CarrinhoDeCompraTeste {
	private static final int UM = 1;
	private Produto celular;

	@BeforeMethod
	public void inicializar() throws Exception {
		double valorUnitario = 1300d;
		celular = new Produto("Nexus 5", valorUnitario);
	}

	@Test(threadPoolSize = 3, invocationCount = 1000)
	public void deve_poder_adicionar_itens_ao_carrinho() {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adicionar(umCelular);
		
		assertThat(carrinho.getItensDoCarrinho(), contains(umCelular));
	}
	
	@Test
	public void deve_poder_remover_itens_do_carrinho() throws Exception {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adicionar(umCelular);
		
		carrinho.remover(umCelular);
		
		assertThat(carrinho.getItensDoCarrinho(), not(contains(umCelular)));
	}
}
