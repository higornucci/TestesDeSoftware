package br.com.htcursos.carrinho;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CarrinhoHibernateDAO implements CarrinhoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(CarrinhoDeCompra carrinho) {
		entityManager.persist(carrinho);
	}

	@Override
	public CarrinhoDeCompra buscarPelo(int id) {
		return entityManager.find(CarrinhoDeCompra.class, id);
		
	}

	public void editar(CarrinhoDeCompra carrinho) {
		
		entityManager.merge(carrinho);
		
	}

}
