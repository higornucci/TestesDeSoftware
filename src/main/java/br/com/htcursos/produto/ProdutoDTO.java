package br.com.htcursos.produto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY)
public class ProdutoDTO {

	private int id;
	private String descricao;
	private double valorUnitario;

	public ProdutoDTO(int id, String descricao, double valorUnitario) {
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

}
