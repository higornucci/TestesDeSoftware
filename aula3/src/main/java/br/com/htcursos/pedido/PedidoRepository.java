package br.com.htcursos.pedido;

import java.util.List;

public interface PedidoRepository {
	List<Pedido> buscarPelo(int numeroDoPedido);

	Integer buscarNumeroDePedidosCadastrados();
	
	void salvar(Pedido pedido);

	Double somarTodosOsPedidos();
	
	List<Pedido> buscarTodos();
}
