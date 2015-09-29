package br.com.htcursos.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaProdutoService {

	private ProdutoRepository produtoRepository;

	@Autowired
	public ConsultaProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoDTO buscarProdutoPeloId(int id) {
		return new ProdutoDTO(id, "Geladeira", 1200d);
	}
}
