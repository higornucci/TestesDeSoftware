package br.com.htcursos.produto;

public interface ProdutoRepository {
	void salvar(Produto produto);
	Produto buscarPelo(int id);
}
