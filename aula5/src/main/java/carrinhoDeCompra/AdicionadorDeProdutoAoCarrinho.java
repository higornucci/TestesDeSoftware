package carrinhoDeCompra;

import javax.transaction.Transactional;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.carrinho.ItemDoCarrinho;
import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ProdutoRepository;

public class AdicionadorDeProdutoAoCarrinho {

	private final CarrinhoRepository carrinhoRepository;
	private final CarrinhoDeCompra carrinhoDeCompra;
	private final ProdutoRepository produtoRepository;

	public AdicionadorDeProdutoAoCarrinho(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository, CarrinhoDeCompraDTO carrinhoDTO) {
		this.carrinhoRepository = carrinhoRepository;
		this.produtoRepository = produtoRepository;
		carrinhoDeCompra = carrinhoRepository.buscarPelo(carrinhoDTO.getId());
	}

	@Transactional
	public void adicionar(ProdutoDTO produtoDTO) {
		Produto produto = produtoRepository.buscarPelo(produtoDTO.getId());
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(produto, 1);
		carrinhoDeCompra.adicionar(itemDoCarrinho);
		carrinhoRepository.inserir(carrinhoDeCompra);
	}

}
