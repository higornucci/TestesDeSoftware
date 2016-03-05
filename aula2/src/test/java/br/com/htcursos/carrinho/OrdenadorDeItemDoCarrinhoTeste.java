package br.com.htcursos.carrinho;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import br.com.htcursos.produto.Produto;

public class OrdenadorDeItemDoCarrinhoTeste {

	@Test
	public void deve_ordenar_uma_lista_desordenada_por_menor_preco() throws Exception {
		//arrange
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		Produto teclado = new Produto("Teclado", 30.00);
		ItemDoCarrinho itemDoCarrinhoTeclado = new ItemDoCarrinho(teclado , 1);
		Produto mouse = new Produto("Mouse", 15.00);
		ItemDoCarrinho itemDoCarrinhoMouse = new ItemDoCarrinho(mouse , 1);
		carrinho.adicionar(itemDoCarrinhoTeclado);
		carrinho.adicionar(itemDoCarrinhoMouse );
		
		//act
		OrdenadorDeItemDoCarrinho ordenador = new OrdenadorDeItemDoCarrinho();
		List<ItemDoCarrinho> listaRetornada = ordenador.ordenarPorMenorPreco(carrinho);
		
		//assert
		assertThat(listaRetornada, contains(itemDoCarrinhoMouse, itemDoCarrinhoTeclado));
	}
}
