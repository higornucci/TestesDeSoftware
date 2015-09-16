package br.com.htcursos.carrinho;

import br.com.htcursos.produto.Produto;

public class ItemDoCarrinho {

	private Produto produto;
	private int quantidade;

	public ItemDoCarrinho(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public double getValorTotal() {
		return 0;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
}
