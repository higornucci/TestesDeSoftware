package carrinhoDeCompra;

import java.util.ArrayList;
import java.util.List;

import br.com.htcursos.carrinho.CarrinhoDeCompra;
import br.com.htcursos.carrinho.CarrinhoRepository;
import br.com.htcursos.carrinho.ItemDoCarrinho;

public class ConsultadorDeCarrinhoDeCompra {

	private final CarrinhoDeCompra carrinhoDeCompra;
	private final CarrinhoRepository carrinhoRepository;

	public ConsultadorDeCarrinhoDeCompra(CarrinhoRepository carrinhoRepository, CarrinhoDeCompraDTO carrinhoDTO) {
		this.carrinhoRepository = carrinhoRepository;
		carrinhoDeCompra = carrinhoRepository.buscarPelo(carrinhoDTO.getId());
	}

	public List<ItemDoCarrinhoDTO> consultarTodosOsItens() {
		List<ItemDoCarrinho> itens = carrinhoRepository.buscarTodosOsItensDo(carrinhoDeCompra);
		return criarDtos(itens);
	}

	private List<ItemDoCarrinhoDTO> criarDtos(List<ItemDoCarrinho> itens) {
		List<ItemDoCarrinhoDTO> itensRetornados = new ArrayList<>();
		for (ItemDoCarrinho itemDoCarrinho : itens) {
			itensRetornados.add(new ItemDoCarrinhoDTO(1, itemDoCarrinho.getProduto().getDescricao(), itemDoCarrinho.getProduto().getValorUnitario(), itemDoCarrinho.getQuantidade()));
		}
		return itensRetornados;
	}

}
