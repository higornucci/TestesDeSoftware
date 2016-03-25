package carrinhoDeCompra;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoHibernateDAO;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ValorInvalido;

@ContextConfiguration(locations="classpath:springbeanstest.xml")
public class CarrinhoHibernateDAOTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private CarrinhoHibernateDAO carrinhoHibernateDAO;
	private CarrinhoDeCompra carrinho;
	
	private ItemDoCarrinho itemDoCarrinho;
	
	@Before
	public void init () throws ValorInvalido{
		carrinho = new CarrinhoDeCompra();
		itemDoCarrinho = criarItemDoCarrinho();
	}
	
	@Test
	public void deve_adicionar_um_item_ao_carrinho() throws Exception {
		carrinho.adicionar(itemDoCarrinho);

		carrinhoHibernateDAO.inserir(carrinho);
		
		assertThat(carrinho.getItensDoCarrinho(), Matchers.contains(itemDoCarrinho));
	}
	
	@Test
	public void deve_remover_um_item_do_carrinho() throws Exception {
		carrinho.adicionar(itemDoCarrinho);
		carrinhoHibernateDAO.inserir(carrinho);
		CarrinhoDeCompra carrinhoRetornado = carrinhoHibernateDAO.buscarPelo(carrinho.getId());
		
		carrinhoRetornado.remover(itemDoCarrinho);
		carrinhoHibernateDAO.editar(carrinhoRetornado);

		carrinhoRetornado = carrinhoHibernateDAO.buscarPelo(carrinhoRetornado.getId());
		assertTrue(carrinhoRetornado.getItensDoCarrinho().isEmpty());
	}

	private ItemDoCarrinho criarItemDoCarrinho() throws ValorInvalido {
		Produto produto = new Produto("Geladeira", 700d);
		return new ItemDoCarrinho(produto, 2);
	}
}
