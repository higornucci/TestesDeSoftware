package produto;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class ProdutoHibernateDAOTeste {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void deve_salvar_um_produto() throws Exception {
		Produto produto = new Produto("Geladeira", 1200d);
		
		produtoRepository.salvar(produto);
		
		assertNotNull(produtoRepository.buscarPelo(produto.getId()));
	}
}
