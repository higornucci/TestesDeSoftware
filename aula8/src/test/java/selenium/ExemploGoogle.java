package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ExemploGoogle  {
	
	private WebDriver driver;
	
	@Before
	public void init() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void deve_buscar_no_google() throws Exception {
        GooglePage googlePage = new GooglePage(driver);
        
        googlePage.buscar("high tech cursos");
        
        assertEquals("high tech cursos - Pesquisa Google", driver.getTitle());
	}
	
	@Test
	public void deve_buscar_no_google_usando_firefox() throws Exception {
		String termoBuscado = "high tech cursos";
		GooglePage googlePage = new GooglePage(driver);

		googlePage.buscar(termoBuscado);
        
        assertEquals("high tech cursos - Pesquisa Google", driver.getTitle());
	}

	@After
	public void finalizar() {
		driver.quit();
	}
}
