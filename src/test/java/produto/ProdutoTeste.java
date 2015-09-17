package produto;

import org.junit.Test;

import br.com.htcursos.produto.Produto;
import br.com.htcursos.produto.ValorInvalido;

public class ProdutoTeste {

	private static final double VALOR_NEGATIVO = -1d;

	@Test(expected = ValorInvalido.class)
	public void nao_deve_permitir_informar_valor_menor_que_zero() throws Exception {
		new Produto("Fogão 4 bocas", VALOR_NEGATIVO);
	}
}
