package br.com.htcursos.pedido;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class PedidoHibernateDAO implements PedidoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pedido> buscarPelo(int numeroDoPedido) {
		return null;
	}

	@Override
	@Transactional
	public Integer buscarNumeroDePedidosCadastrados() {
		return ((Long) entityManager.createQuery("SELECT COUNT(id) FROM Pedido").getSingleResult()).intValue();
	}

	@Override
	@Transactional
	public void salvar(Pedido pedido) {
		entityManager.persist(pedido);
	}

	@Override
	@Transactional
	public Double somarTodosOsPedidos() {
		return (Double) entityManager.createQuery("SELECT SUM(produto.valorUnitario) FROM Pedido pedido LEFT JOIN pedido.produtos produto").getSingleResult();
	}

	@Override
	public List<Pedido> buscarTodos() {
		return entityManager.createQuery("FROM Pedido").getResultList();
	}

}
