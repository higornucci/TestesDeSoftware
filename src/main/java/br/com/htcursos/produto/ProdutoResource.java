package br.com.htcursos.produto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("produtos")
@Component
public class ProdutoResource {

	@Autowired
	private ConsultaProdutoService consultaProdutoService;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoDTO buscarProdutoPeloId(@PathParam("id") Integer id) {
		return consultaProdutoService.buscarProdutoPeloId(id);
	}
}
