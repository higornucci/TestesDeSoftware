package br.com.htcursos.desconto;

public class CalculadoraDeDesconto {
	public double calcularDescontoPara(double valorGasto) {
		if(valorGasto > 100 && valorGasto <= 150) {
			return valorGasto - (valorGasto * 0.05);
		} else if(valorGasto > 150) {
			return valorGasto - (valorGasto * 0.1);
		}
		return valorGasto;
	}
}
