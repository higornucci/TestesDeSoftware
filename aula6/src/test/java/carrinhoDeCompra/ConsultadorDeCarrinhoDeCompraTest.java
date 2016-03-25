package carrinhoDeCompra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoHibernateDAO;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ValorInvalido;

public class ConsultadorDeCarrinhoDeCompraTest {
	
	private CarrinhoRepository carrinhoRepository;
	
	@Before
	public void init() throws ValorInvalido {
		carrinhoRepository = mock(CarrinhoHibernateDAO.class);
	}

	@Test
	public void deve_retornar_os_itens_de_um_carrinho() throws Exception {
		List<ItemDoCarrinho> itens = Arrays.asList(new ItemDoCarrinho(new Produto("Geladeira", 1200d), 2));
		ItemDoCarrinhoDTO geladeiraDTO = new ItemDoCarrinhoDTO(1, "Geladeira", 1200d, 2);
		List<ItemDoCarrinhoDTO> itensDTOsEsperados = Arrays.asList(geladeiraDTO);
		CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
		
		
		when(carrinhoRepository.buscarPelo(1)).thenReturn(carrinhoDeCompra);
		when(carrinhoRepository.buscarTodosOsItensDo(carrinhoDeCompra)).thenReturn(itens);
		
		CarrinhoDeCompraDTO carrinhoDTO = new CarrinhoDeCompraDTO(1);
		ConsultadorDeCarrinhoDeCompra consultadorDeCarrinhoDeCompra = new ConsultadorDeCarrinhoDeCompra(carrinhoRepository, carrinhoDTO );
		List<ItemDoCarrinhoDTO> itensDTOsRetornados = consultadorDeCarrinhoDeCompra.consultarTodosOsItens();
		
		assertEquals(itensDTOsEsperados, itensDTOsRetornados);
	}
}
