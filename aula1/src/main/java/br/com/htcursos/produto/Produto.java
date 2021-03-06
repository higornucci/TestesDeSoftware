package br.com.htcursos.produto;

import br.com.htcursos.EntidadeBase;

public class Produto extends EntidadeBase {

	private double valorUnitario;
	private String descricao;
	
	Produto(){
	}

	public Produto(String descricao, double valorUnitario) throws ValorInvalido {
		verificarSeValorMenorQueZero(valorUnitario);
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}
	
	private void verificarSeValorMenorQueZero(double valorUnitario) throws ValorInvalido {
		if(valorUnitario < 0) {
			throw new ValorInvalido();
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
}
