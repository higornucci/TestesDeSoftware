package frete;

public class CalculadoraDeFrete {

	private String cepDeOrigem;
	private ServicoDeFrete servicoDeFrete;

	public CalculadoraDeFrete(ServicoDeFrete servicoDeFrete, String cepDeOrigem) {
		this.servicoDeFrete = servicoDeFrete;
		this.cepDeOrigem = cepDeOrigem;
	}

	public double calcularFretePara(String cepDeDestino) {
		return servicoDeFrete.calcularFretePara(cepDeOrigem, cepDeDestino);
	}

}
