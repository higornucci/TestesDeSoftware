package selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExemploGoogle  {
	
	private WebDriver driver;

	@Test
	public void deve_buscar_no_google() throws Exception {
		driver = new HtmlUnitDriver();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("high tech cursos");

        element.submit();

        assertEquals("high tech cursos - Pesquisa Google", driver.getTitle());
	}
	
	@Test
	public void deve_buscar_no_google_usando_firefox() throws Exception {
		driver = new FirefoxDriver();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("high tech cursos");

        element.submit();

        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("high tech cursos"));
        
        assertEquals("high tech cursos - Pesquisa Google", driver.getTitle());
	}

	@After
	public void finalizar() {
		driver.quit();
	}
}
