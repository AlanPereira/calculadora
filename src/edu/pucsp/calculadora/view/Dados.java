package edu.pucsp.calculadora.view;

import java.io.Serializable;

public class Dados implements Serializable{

	private String expressao;

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}
}
