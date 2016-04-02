package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	private WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		irParaPaginaDeBusca();
	}
	
	public GooglePage buscar(String termo) {
		digitarTermoNoCampoDeBusca(termo);
        clicarEmPesquisar();
		return this;
	}

	private void clicarEmPesquisar() {
		driver.findElement(By.name("btnG")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("ires")));
	}

	private void digitarTermoNoCampoDeBusca(String termo) {
		driver.findElement(By.name("q")).sendKeys(termo);
	}

	private void irParaPaginaDeBusca() {
		driver.get("http://www.google.com");
	}
}
