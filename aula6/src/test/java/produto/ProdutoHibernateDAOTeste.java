package produto;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ProdutoHibernateDAO;
import br.com.htcursos.produto.ProdutoRepository;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class ProdutoHibernateDAOTeste extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProdutoRepository produtoRepository;
	private Produto geladeira;
	private Produto fogao;
	private Produto microondas;

	@Before
	public void init() throws Exception {
		geladeira = new Produto("Geladeira", 1200d);
		produtoRepository.salvar(geladeira);
		fogao = new Produto("Fogão", 1000d);
		produtoRepository.salvar(fogao);
		microondas = new Produto("Microondas", 200d);
		produtoRepository.salvar(microondas);
	}

	@Test
	public void deve_salvar_um_produto() throws Exception {
		Produto geladeira = new Produto("Geladeira", 1200d);
		EntityManager entityManager = Mockito.mock(EntityManager.class);

		ProdutoRepository produtoRepository = new ProdutoHibernateDAO(entityManager);

		produtoRepository.salvar(geladeira);

		Mockito.verify(entityManager, Mockito.times(1)).persist(Mockito.any(Produto.class));
	}

	@Test
	public void deve_buscar_produtos_por_faixa_de_preco() throws Exception {
		double precoMinimo = 1000d;
		double precoMaximo = 1500d;
		ProdutoRepository produtoRepository = Mockito.mock(ProdutoHibernateDAO.class);
		Mockito.when(produtoRepository.buscarPorFaixaDePreco(precoMinimo, precoMaximo))
				.thenReturn(Arrays.asList(geladeira, fogao));

		List<Produto> produtosRetornados = produtoRepository.buscarPorFaixaDePreco(precoMinimo, precoMaximo);

		assertThat(produtosRetornados, contains(geladeira, fogao));
	}
}
