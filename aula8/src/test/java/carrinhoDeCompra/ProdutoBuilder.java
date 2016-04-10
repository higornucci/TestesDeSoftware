package carrinhoDeCompra;

import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ValorInvalido;

public class ProdutoBuilder {

	private String descricao;
	private double preco;
	
	public ProdutoBuilder() {
		descricao = "Geladeira";
		preco = 1200d;
	}

	public static ProdutoBuilder novo() {
		return new ProdutoBuilder();
	}

	public ProdutoBuilder chamado(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public ProdutoBuilder comPreco(double preco) {
		this.preco = preco;
		return this;
	}

	public Produto criar() throws ValorInvalido {
		return new Produto(descricao, preco);
	}

}
