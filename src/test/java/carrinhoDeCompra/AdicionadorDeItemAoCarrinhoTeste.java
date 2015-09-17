package carrinhoDeCompra;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class AdicionadorDeItemAoCarrinhoTeste {
	private static final int UM = 1;
	private Produto celular;

	@Before
	public void inicializar() throws Exception {
		double valorUnitario = 1300d;
		celular = new Produto("Nexus 5", valorUnitario);
	}
	
	@Test
	public void deve_ser_possivel_adicionar_um_item() throws Exception {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		CarrinhoRepository carrinhoRepository = Mockito.mock(CarrinhoDAO.class);
		
		AdicionadorDeItemAoCarrinho adicionador = 
					new AdicionadorDeItemAoCarrinho(carrinhoRepository);
		adicionador.adicionar(umCelular, carrinho);
		
		Mockito.verify(carrinhoRepository).salvar(carrinho);
	}
}
