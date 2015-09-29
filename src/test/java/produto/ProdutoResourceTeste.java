package produto;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

public class ProdutoResourceTeste {
	
	@Test
	public void deve_trazer_um_produto_pelo_id() throws Exception {
		given().
			accept(MediaType.APPLICATION_JSON).
		expect().
			statusCode(200).
			body("descricao", equalTo("Geladeira")).
		when().
			get("http://localhost:8080/testesdesoftware/rest/produtos/5");
	}
}
