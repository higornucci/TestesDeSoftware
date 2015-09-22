package br.com.htcursos.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProdutoHibernateDAO implements ProdutoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Produto buscarPelo(int id) {
		return entityManager.find(Produto.class, id);
	}

	@Override
	public void salvar(Produto produto) {
		entityManager.persist(produto);
	}

}
