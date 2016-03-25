package carrinhoDeCompra;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class CarrinhoDeCompraTeste {
	private static final int UM = 1;
	private Produto celular;
	private Produto notebook;
	private Produto geladeira;

	@Before
	public void inicializar() throws Exception {
		double valorUnitario = 1300d;
		celular = new Produto("Nexus 5", valorUnitario);
		notebook = new Produto("Notebook", valorUnitario);
		geladeira = new Produto("Geladeira", valorUnitario);
	}

	@Test
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
	
	
	@Test
	public void testName() throws Exception {
		ItemDoCarrinho umaGeladeira = new ItemDoCarrinho(geladeira, UM);
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		ItemDoCarrinho umNotebook = new ItemDoCarrinho(notebook, UM);
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adicionar(umaGeladeira);
		carrinho.adicionar(umCelular);
		carrinho.adicionar(umNotebook);
		
		List<ItemDoCarrinho> listaOrdenada = carrinho.getItensDoCarrinho()
				.stream().sorted((i1, i2) -> i1.getProduto().getDescricao()
						.compareTo(i2.getProduto().getDescricao())).collect(Collectors.toList());
		
		assertThat(listaOrdenada, contains(umaGeladeira, umCelular, umNotebook));
	}
}
