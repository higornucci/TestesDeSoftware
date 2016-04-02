package produto;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import br.com.htcursos.produto.Produto;

public class ProdutoPageTeste {

	private WebDriver driver;
	
	@Before
	public void init() {
		driver = new HtmlUnitDriver();
	}
	
	@Test
	public void deve_cadastrar_um_produto() throws Exception {
		Produto notebook = new Produto("Notebook", 2500d);
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.cadastrar(notebook);
		
		 assertTrue(driver.getPageSource().contains(notebook.getDescricao()));
	}
	
	@Test
	public void deve_editar_um_produto() throws Exception {
		Produto notebook = new Produto("Notebook", 2500d);
		notebook.setId(4);
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.editar(notebook);
		
		assertTrue(driver.getPageSource().contains(notebook.getDescricao()));
	}
}
