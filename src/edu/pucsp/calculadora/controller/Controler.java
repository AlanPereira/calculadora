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
	
	public void verificarExpressao(String txt)
	{
		VerificaExpressao expr = new VerificaExpressao();
		if(expr.validaExpressao(txt)){
			
		}else{
			imprimir();
			gravar();
		}
			
	}
	public void imprimir(){
		
	}
	
	public void gravar(){
		
	}
	
}
