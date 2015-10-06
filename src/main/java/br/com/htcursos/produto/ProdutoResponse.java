package br.com.htcursos.produto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoResponse {

	private int id;
	private String descricao;
	private double valorUnitario;
	
	ProdutoResponse() {
	}

	public ProdutoResponse(int id, String descricao, double valorUnitario) {
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
