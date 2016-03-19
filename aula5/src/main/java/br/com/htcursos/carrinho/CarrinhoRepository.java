package br.com.htcursos.carrinho;

public interface CarrinhoRepository {
	void inserir(CarrinhoDeCompra carrinho);
	CarrinhoDeCompra buscarPelo(int id);
}
