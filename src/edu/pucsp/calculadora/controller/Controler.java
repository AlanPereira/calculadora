package edu.pucsp.calculadora.controller;

import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;
import edu.pucsp.calculadora.view.TelaCalc;

public class Controler implements IControle{
	private ITela tela;
	
	public ITela getITela() {
		return tela;
	}

	public void setITela(ITela tela) {
		this.tela = tela;
	}
	

	public Controler()
	{
		setITela(new TelaCalc(this));//talves trocar para o iniciar;
	}
	
	public void iniciar(){
		getITela().iniciar();
	}
		
	private void verificarExpressao(String txt)
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
	public String calcular(String expressao) {
		verificarExpressao(expressao);
		return null;
	}

}
