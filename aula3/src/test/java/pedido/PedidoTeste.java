package pedido;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.htcursos.pedido.Pedido;
import br.com.htcursos.pedido.PedidoRepository;
import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ProdutoRepository;
import br.com.htcursos.produto.ValorInvalido;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class PedidoTeste extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void deve_gerar_um_codigo_de_um_pedido() throws Exception {
		// arrange
		criarPedido();
		criarPedido();
		Integer numeroDoPedidoEsperado = 3;
		List<Produto> produtos = Arrays.asList(criarProduto("Teclado", 30d));
		
		// act
		Pedido pedido = Pedido.criar(produtos, pedidoRepository);

		// assert
		assertThat(pedido.getNumero(), is(numeroDoPedidoEsperado));
	}
	
	@Test
	public void deve_somar_o_valor_de_todos_os_pedidos() throws Exception {
		// arrange
		Double totalEsperado = 100d;
		List<Produto> produtosPedido1 = Arrays.asList(criarProduto("Teclado", 30d));
		List<Produto> produtosPedido2 = Arrays.asList(criarProduto("Fone", 70d));
		Pedido pedido1 = Pedido.criar(produtosPedido1, pedidoRepository);
		pedidoRepository.salvar(pedido1);
		Pedido pedido2 = Pedido.criar(produtosPedido2, pedidoRepository);
		pedidoRepository.salvar(pedido2);
		
		// act
		Double totalRetornado = pedidoRepository.somarTodosOsPedidos();
		
		// assert
		assertThat(totalRetornado, is(totalEsperado));
	}
	
	private Pedido criarPedido() throws ValorInvalido {
		Produto notebook = criarProduto("Notebook", 1200d);
		Produto teclado = criarProduto("Teclado", 45d);
		List<Produto> produtos = Arrays.asList(notebook, teclado);
		
		Pedido pedido = Pedido.criar(produtos, pedidoRepository);
		pedidoRepository.salvar(pedido);
		return pedido;
	}

	private Produto criarProduto(String nome, double valorUnitario) throws ValorInvalido {
		Produto notebook = new Produto(nome, valorUnitario);
		produtoRepository.salvar(notebook);
		return notebook;
	}
	
}
