package br.com.htcursos.carrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import carrinho.FreteService;

public class CarrinhoDeCompra {
	
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

	public double getValorComFrete(FreteService freteService) {
		double totalDosItens = itensDoCarrinho.stream().mapToDouble(s -> s.getProduto().getValorUnitario()).sum();
		return totalDosItens + freteService.calcular();
	}
}
