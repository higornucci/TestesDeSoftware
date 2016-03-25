package br.com.htcursos.carrinho;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.htcursos.EntidadeBase;
import br.com.htcursos.produto.Produto;

@Entity
public class ItemDoCarrinho extends EntidadeBase {

	@ManyToOne
	private Produto produto;
	private int quantidade;

	public ItemDoCarrinho(){	
	}
	
	public ItemDoCarrinho(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public double getValorTotal() {
		return quantidade * produto.getValorUnitario();
	}

	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
}
