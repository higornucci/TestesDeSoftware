package br.com.htcursos.carrinho;

public class Compra {
	AndamentoDaCompra andamentoDaCompra;
	private double valor;
	
	public Compra(double valor) {
		this.valor = valor;
		andamentoDaCompra = AndamentoDaCompra.AGUARDANDO_PAGAMENTO;
	}
	
	public void pagar() {
		andamentoDaCompra = AndamentoDaCompra.PAGA;
	}
	
	public void enviarProdutos() throws PagamentoNaoEfetuado {
		if(AndamentoDaCompra.PAGA.equals(andamentoDaCompra)) {
			andamentoDaCompra = AndamentoDaCompra.ENVIADA;
		} else {
			throw new PagamentoNaoEfetuado();
		}
	}
	
	public boolean foiPaga() {
		return AndamentoDaCompra.PAGA.equals(andamentoDaCompra) || AndamentoDaCompra.ENVIADA.equals(andamentoDaCompra);
	}

	public boolean foiEnviada() {
		return AndamentoDaCompra.ENVIADA.equals(andamentoDaCompra);
	}
}
