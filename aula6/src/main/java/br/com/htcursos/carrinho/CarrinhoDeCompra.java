package br.com.htcursos.carrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.htcursos.EntidadeBase;

@Entity
public class CarrinhoDeCompra extends EntidadeBase {
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<ItemDoCarrinho> itensDoCarrinho;
	
	public CarrinhoDeCompra() {
		itensDoCarrinho = new ArrayList<ItemDoCarrinho>();
	}

	public void adicionar(ItemDoCarrinho itemDoCarrinho) {
		itensDoCarrinho.add(itemDoCarrinho);
	}

	public void remover(ItemDoCarrinho itemDoCarrinho) {
		itensDoCarrinho.remove(itemDoCarrinho);
	}

	public List<ItemDoCarrinho> getItensDoCarrinho() {
		return Collections.unmodifiableList(itensDoCarrinho);
	}
}
