package frete;

public class CepIncorreto extends Exception {
	private static final long serialVersionUID = 1L;

	public CepIncorreto() {
		super("O CEP está escrito incorretamente.");
	}
}
