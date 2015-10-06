package br.com.htcursos.produto;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("produtos")
public class ProdutoResource {

	@Autowired
	private ConsultaProdutoService consultaProdutoService;
	
	@Autowired
	private AdicionaProdutoService adicionaProdutoService;

	@Context
	protected UriInfo uriInfo;

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ProdutoResponse buscarProdutoPeloId(@PathParam("id") Integer id) {
		return consultaProdutoService.buscarProdutoPeloId(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response inserir(ProdutoRequest produtoRequest) throws ValorInvalido {
		Integer produtoId = adicionaProdutoService.inserir(produtoRequest);
		URI location = uriInfo.getAbsolutePathBuilder().path(produtoId.toString()).build();
		return Response.created(location).status(200).build();
	}
}
