package br.com.htcursos.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaProdutoService {

	private ProdutoRepository produtoRepository;

	@Autowired
	public ConsultaProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoResponse buscarProdutoPeloId(int id) {
		return converter(produtoRepository.buscarPelo(id));
	}

	private ProdutoResponse converter(Produto produto) {
		return new ProdutoResponse(produto.getId(), produto.getDescricao(), produto.getValorUnitario());
	}

	public List<ProdutoResponse> buscarTodos() {
		List<Produto> produtos = produtoRepository.buscarTodos();
		return converter(produtos);
	}

	private List<ProdutoResponse> converter(List<Produto> produtos) {
		List<ProdutoResponse> produtosResponse = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosResponse.add(converter(produto));
		}
		return produtosResponse;
	}
}
