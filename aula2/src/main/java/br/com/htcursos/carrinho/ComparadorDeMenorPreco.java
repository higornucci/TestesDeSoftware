package br.com.htcursos.carrinho;

import java.util.Comparator;

public class ComparadorDeMenorPreco implements Comparator<ItemDoCarrinho> {

	@Override
	public int compare(ItemDoCarrinho itemDoCarrinho, ItemDoCarrinho itemDoCarrinho2) {
		return itemDoCarrinho.getValorTotal() < itemDoCarrinho2.getValorTotal() ? -1 : 1;
	}
	
}
