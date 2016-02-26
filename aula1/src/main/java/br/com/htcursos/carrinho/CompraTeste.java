package br.com.htcursos.carrinho;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompraTeste {

	@Test
	public void deve_pagar_uma_compra() throws Exception {
		//arrange
		double valorDaCompra = 120d;
		Compra compra = new Compra(valorDaCompra);
		
		//act
		compra.pagar();
		
		//assert
		assertTrue(compra.foiPaga());
	}
	
	@Test
	public void deve_enviar_uma_conta_paga() throws Exception {
		Compra compra = new Compra(120d);
		compra.pagar();
		
		compra.enviarProdutos();
		
		assertTrue(compra.foiEnviada());
	}
	
	@Test(expected = PagamentoNaoEfetuado.class)
	public void nao_deve_enviar_uma_conta_nao_paga() throws Exception {
		Compra compra = new Compra(120d);
		
		compra.enviarProdutos();
	}
	
	@Test
	public void deve_marcar_uma_conta_enviada_como_paga() throws Exception {
		Compra compra = new Compra(120d);
		compra.pagar();
		
		compra.enviarProdutos();
		
		assertTrue(compra.foiPaga());
	}
	
}
