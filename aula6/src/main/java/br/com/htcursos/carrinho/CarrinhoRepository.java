package br.com.htcursos.carrinho;

import java.util.List;

public interface CarrinhoRepository {
	void inserir(CarrinhoDeCompra carrinho);
	CarrinhoDeCompra buscarPelo(int id);
	List<ItemDoCarrinho> buscarTodosOsItensDo(CarrinhoDeCompra carrinhoDeCompra);
}
