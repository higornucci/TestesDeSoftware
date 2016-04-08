package produto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.htcursos.produto.Produto;

public class ProdutoPage {

	private WebDriver driver;

	public ProdutoPage(WebDriver driver) {
		this.driver = driver;
		irParaCadastroDeProdutos();
	}

	public void cadastrar(Produto produto) {
		salvarProduto(produto);
	}
	
	public void editar(Produto produto) {
		clicarNoBotaoEditarDo(produto);
		
		salvarProduto(produto);
	}

	private void salvarProduto(Produto produto) {
		digitarDescricao(produto.getDescricao());
		digitarValorUnitario(produto.getValorUnitario());
		
		clicarEmSalvar();
	}

	private void clicarNoBotaoEditarDo(Produto produto) {
		driver.findElement(By.className("botao-edicao-" + produto.getId())).click();
	}

	private void irParaCadastroDeProdutos() {
		driver.get("http://localhost:8080/testesdesoftware/produto.xhtml");
	}

	private void clicarEmSalvar() {
		driver.findElement(By.name("botao-salvar")).click();
	}

	private void digitarValorUnitario(Double valorUnitario) {
		driver.findElement(By.name("campo-valor-unitario")).sendKeys(valorUnitario.toString());
	}

	private void digitarDescricao(String descricao) {
		driver.findElement(By.name("campo-descricao")).sendKeys(descricao);
	}
}
