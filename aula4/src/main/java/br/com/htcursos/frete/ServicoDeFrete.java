package br.com.htcursos.frete;

import frete.CepIncorreto;

public interface ServicoDeFrete {
	double calcularFretePara(String cepDeOrigem, String cepDeDestino) throws ServicoDeFreteIndisponivel, CepIncorreto;
}
