package produto;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.htcursos.produto.Produto;

public class ProdutoPageTeste {

	private WebDriver driver;
	
	@BeforeMethod
	public void init() {
		driver = new FirefoxDriver();
	}
	
	@Test(threadPoolSize = 3, invocationCount = 10)
	public void deve_cadastrar_um_produto() throws Exception {
		Produto notebook = new Produto("Notebook", 2500d);
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.cadastrar(notebook);
		
		 assertTrue(driver.getPageSource().contains(notebook.getDescricao()));
	}
	
	@AfterMethod
	public void finalizar() {
		driver.quit();
	}
}
