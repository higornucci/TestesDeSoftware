package produto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class HTPageTest {
	
	private WebDriver driver;
	
	@Before
	public void init() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void deve_navegar_pela_pagina_da_ht() {
		driver.get("http://hightechcursos.com.br/");
		Actions action = new Actions(driver);
		WebElement linkCadastros = driver.findElement(By.linkText("Cadastros"));
		WebElement botaoInformativo = driver.findElement(By.linkText("Informativo"));
		action
			.moveToElement(linkCadastros)
			.click()
			.moveToElement(botaoInformativo)
			.click()
			.build()
			.perform();
		
		assertTrue(driver.getCurrentUrl().equals("http://hightechcursos.com.br/index.php?p=frmcadastro"));
	}
}
