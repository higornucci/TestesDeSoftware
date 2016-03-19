package produto;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import br.com.htcursos.produto.ProdutoRequest;

public class ProdutoResourceTeste {
	
	@Test
	public void deve_trazer_um_produto_pelo_id() throws Exception {
		given().
			accept(MediaType.APPLICATION_JSON).
		expect().
			statusCode(200).
			body("id", equalTo(5)).
			body("descricao", equalTo("Geladeira")).
		when().
			get("http://localhost:8080/aula5/rest/produtos/5");
	}
	
	@Test
	public void deve_retornar_todos_os_produtos() throws Exception {
		Response json = given().
				accept(MediaType.APPLICATION_JSON).
			expect().
				statusCode(200).
				body("id", Matchers.hasItem(5)).
			when().
				get("http://localhost:8080/aula5/rest/produtos/");
		
		JsonPath jsonPath = new JsonPath(json.getBody().asString());
		List<Integer> ids = jsonPath.getList("id");
		List<String> descricoes = jsonPath.getList("descricao");
		List<Float> valoresUnitarios = jsonPath.getList("valorUnitario");
		
		assertThat(ids, hasItem(5));
		assertThat(descricoes, hasItem("Geladeira"));
		assertThat(valoresUnitarios, hasItem(1200f));
	}
	
	@Test
	public void deve_adicionar_um_produto() throws Exception {
		ProdutoRequest produtoRequest = new ProdutoRequest("iPad", 3000d);
		given().
			contentType(MediaType.APPLICATION_JSON).
			body(produtoRequest).
	       	post("http://localhost:8080/testesdesoftware/rest/produtos/").
	    then()
	    	.statusCode(200);
	}
	
	@Test
	public void deve_excluir_um_produto() throws Exception {
		given().
	       	delete("http://localhost:8080/testesdesoftware/rest/produtos/1").
	    then()
	    	.statusCode(200);
	}
	
	@Test
	public void deve_trazer_um_produto_pelo_id_json_path() throws Exception {
		Response json = given().
			accept(MediaType.APPLICATION_JSON).
		when().
			get("http://localhost:8080/testesdesoftware/rest/produtos/5");
		
		JsonPath jsonPath = new JsonPath(json.getBody().asString());
		double valorUnitario = jsonPath.getDouble("valorUnitario");
		
		assertTrue(1200d == valorUnitario);
	}
}
