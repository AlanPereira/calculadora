package edu.pucsp.calculadora.controller;

import edu.pucsp.calculadora.view.TelaCalc;

public class Controler {
	private TelaCalc tela;
	
	public TelaCalc getTela() {
		return tela;
	}

	public void setTela(TelaCalc tela) {
		this.tela = tela;
	}

	public Controler()
	{
		 
	}
	
	public void iniciar()
	{
		setTela(new TelaCalc(this));
	}
}
