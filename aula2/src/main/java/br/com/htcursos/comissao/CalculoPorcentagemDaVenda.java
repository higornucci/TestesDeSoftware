package br.com.htcursos.comissao;

public class CalculoPorcentagemDaVenda {

	public Double calcularPorcentagemDeComissao(Double valorDaVenda) {
		if (valorDaVenda <= 10000.00) {
			return arredondarParaDuasCasasDecimais(valorDaVenda * 0.05);
		}
		return arredondarParaDuasCasasDecimais(valorDaVenda * 0.06);
	}

	private Double arredondarParaDuasCasasDecimais(Double valor) {
		return (double) (Math.floor(valor * 100)/100);
	}

}
