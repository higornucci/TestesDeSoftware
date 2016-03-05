package br.com.htcursos.pedido;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.htcursos.produto.Produto;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer numero;
	
	@ManyToMany
	private List<Produto> produtos;
	
	Pedido() {
	}

	private Pedido(List<Produto> produtos, Integer numeroDoPedido) {
		this.produtos = produtos;
		numero = numeroDoPedido;
	}

	public Integer getNumero() {
		return this.numero;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public static Pedido criar(List<Produto> produtos, PedidoRepository pedidoRepository) {
		Integer numeroDePedidosCadastrados = pedidoRepository.buscarNumeroDePedidosCadastrados();
		return new Pedido(produtos, numeroDePedidosCadastrados + 1);
	}

}
