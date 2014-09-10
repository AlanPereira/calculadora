package edu.pucsp.calculadora.controller;

import edu.pucsp.calculadora.view.TelaCalc;

public class Controler implements IControle{
	private ITela tela;
	
	public ITela getTela() {
		return tela;
	}

	public void setITela(ITela tela) {
		this.tela = tela;
	}

	public Controler()
	{
		 
	}
		
	public void verificarExpressao(String txt)
	{
		VerificaExpressao expr = new VerificaExpressao();
		if(expr.validaExpressao(txt)){
			//continuar
		}else{
			imprimir();
			gravar();
		}
			
	}
	public void imprimir(){
		
	}
	
	public void gravar(){
		
	}

	@Override
	public String calcular(String expressão) {
		// TODO Auto-generated method stub
		return null;
	}

}
