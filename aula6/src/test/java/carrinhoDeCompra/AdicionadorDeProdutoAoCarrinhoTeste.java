package carrinhoDeCompra;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoHibernateDAO;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ProdutoHibernateDAO;
import br.com.htcursos.produto.ProdutoRepository;
import br.com.htcursos.produto.ValorInvalido;

public class AdicionadorDeProdutoAoCarrinhoTeste {
	
	private ProdutoRepository produtoRepository;
	private CarrinhoRepository carrinhoRepository;
	private ProdutoDTO produtoDTO;
	private CarrinhoDeCompraDTO carrinhoDTO;
	private Produto geladeira;
	private CarrinhoDeCompra carrinhoDeCompra;

	@Before
	public void init() throws ValorInvalido {
		produtoDTO = new ProdutoDTO(1, "Geladeira", 1200d);
		carrinhoDTO = new CarrinhoDeCompraDTO(1);
		
		geladeira = new Produto(produtoDTO.getDescricao(), produtoDTO.getValorUnitario());
		carrinhoDeCompra = new CarrinhoDeCompra();
		
		produtoRepository = mock(ProdutoHibernateDAO.class);
		carrinhoRepository = mock(CarrinhoHibernateDAO.class);
	}

	@Test
	public void deve_poder_adicionar_um_item_ao_carrinho() throws Exception {
		when(produtoRepository.buscarPelo(produtoDTO.getId())).thenReturn(geladeira);
		when(carrinhoRepository.buscarPelo(carrinhoDTO.getId())).thenReturn(carrinhoDeCompra);
		
		AdicionadorDeProdutoAoCarrinho adicionador = new AdicionadorDeProdutoAoCarrinho(carrinhoRepository, produtoRepository, carrinhoDTO);
		adicionador.adicionar(produtoDTO);
		
		verify(carrinhoRepository, times(1)).inserir(carrinhoDeCompra);
	}
}
