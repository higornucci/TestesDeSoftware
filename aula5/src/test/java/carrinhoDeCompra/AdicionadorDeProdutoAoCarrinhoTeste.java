package carrinhoDeCompra;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoHibernateDAO;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.produto.Produto;

public class AdicionadorDeProdutoAoCarrinhoTeste {

	@Test
	public void deve_poder_adicionar_um_item_ao_carrinho() throws Exception {
		Produto geladeira = new Produto("Geladeira", 2000d);
		CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
		CarrinhoRepository carrinhoRepository = Mockito.mock(CarrinhoHibernateDAO.class);
		
		AdicionadorDeProdutoAoCarrinho adicionador = new AdicionadorDeProdutoAoCarrinho(carrinhoDeCompra, carrinhoRepository);
		adicionador.adicionar(geladeira);
		
		Mockito.verify(carrinhoRepository).salvar(carrinhoDeCompra);
	}
}
