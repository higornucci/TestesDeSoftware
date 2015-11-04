package br.com.htcursos.produto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.htcursos.MensagemUtil;

@Controller
public class ProdutoController {

	@Autowired
	private AdicionaProdutoService adicionaProdutoService;
	
	@Autowired
	private ConsultaProdutoService consultaProdutoService;
	
	private ProdutoResponse produto;
	
	List<ProdutoResponse> produtos;

	private boolean edicao;
	
	public ProdutoController() {
		produto = new ProdutoResponse();
		produtos = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		produtos = consultaProdutoService.buscarTodos();
	}
	
	public void salvar() throws ValorInvalido {
		try {
			ProdutoRequest produtoRequest = new ProdutoRequest(produto.getDescricao(), produto.getValorUnitario());
			adicionaProdutoService.inserir(produtoRequest);
			MensagemUtil.mensagemInfo("Usuário salvo.");
			
			if(!edicao) {
				produtos.add(produto);
			}
			produto = new ProdutoResponse();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Login já existente.");
		}
	}
	
	public void prepararInclusao() {
		this.edicao = false;
		produto = new ProdutoResponse();
	}
	
	public void prepararEdicao(ProdutoResponse produto) {
		this.edicao = true;
		this.produto = produto;
	}
	
	public ProdutoResponse getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoResponse produto) {
		this.produto = produto;
	}
	
	public List<ProdutoResponse> getProdutos() {
		return produtos;
	}

	public boolean isEdicao() {
		return edicao;
	}
}
