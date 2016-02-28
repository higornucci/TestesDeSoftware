package br.com.htcursos.carrinho;

import java.util.List;

public class OrdenadorDeItemDoCarrinho {

	public List<ItemDoCarrinho> ordenarPorMenorPreco(CarrinhoDeCompra carrinho) {
		ComparadorDeMenorPreco comparador = new ComparadorDeMenorPreco();
		List<ItemDoCarrinho> listaOrdenada = carrinho.getItensDoCarrinho();
		listaOrdenada.sort(comparador);
		return listaOrdenada;
	}

}
