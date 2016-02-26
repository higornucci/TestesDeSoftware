package br.com.htcursos.produto;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdutoTeste {

	@Test(expected=ValorInvalido.class)
	public void nao_deve_criar_produto_com_valor_negativo() throws Exception {
		//arrange
		double valorDoProduto = -1d;
		String nomeDoProduto = "Notebook";
		
		//act
		new Produto(nomeDoProduto, valorDoProduto);
	}
}
