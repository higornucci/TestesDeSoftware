package br.com.htcursos.carrinho;

public interface CarrinhoRepository {
	void salvar(CarrinhoDeCompra carrinho);
	void buscarPelo(int id);
}
