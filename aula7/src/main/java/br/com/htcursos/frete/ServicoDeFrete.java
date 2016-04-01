package br.com.htcursos.frete;

public interface ServicoDeFrete {
	double calcularFretePara(String cepDeOrigem, String cepDeDestino) throws ServicoDeFreteIndisponivel;
}
