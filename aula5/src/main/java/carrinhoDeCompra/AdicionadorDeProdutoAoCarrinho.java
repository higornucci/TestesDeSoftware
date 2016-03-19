package carrinhoDeCompra;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;

public class AdicionadorDeProdutoAoCarrinho {

	private final CarrinhoDeCompra carrinhoDeCompra;
	private final CarrinhoRepository carrinhoRepository;

	public AdicionadorDeProdutoAoCarrinho(CarrinhoDeCompra carrinhoDeCompra, CarrinhoRepository carrinhoRepository) {
		this.carrinhoDeCompra = carrinhoDeCompra;
		this.carrinhoRepository = carrinhoRepository;
	}

	public void adicionar(Produto geladeira) {
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(geladeira, 1);
		carrinhoDeCompra.adicionar(itemDoCarrinho);
		carrinhoRepository.salvar(carrinhoDeCompra);
	}

}
