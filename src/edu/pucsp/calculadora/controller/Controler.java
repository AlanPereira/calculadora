package edu.pucsp.calculadora.controller;

import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;
import edu.pucsp.calculadora.model.Calculadora;
import edu.pucsp.calculadora.view.TelaCalc;

public class Controler implements IControle{
	private ITela tela;
	private VerificaExpressao verifExpr;
	
	private ITela getITela() {
		return tela;
	}

	private void setITela(ITela tela) {
		this.tela = tela;
	}
	
	public Controler()
	{
		setITela(new TelaCalc(this));//talves trocar para o iniciar;
		setVerifExpr(new VerificaExpressao());
	}
	
	public void iniciar(){
		getITela().iniciar();
	}
		
	public void imprimir(){
		
	}
	
	public void gravar(){
		
	}

	@Override
	public String calcular(String expressao) {
		String result="";
		
		if(getVerifExpr().validaExpressao(expressao)){
			result = (new Calculadora().CalcularExp((new PreparaEquacao()).converteInfixa(getVerifExpr().getList())));
		}else
			result = "Erro de sintaxe";
		return result;
		 
	}

	public VerificaExpressao getVerifExpr() {
		return verifExpr;
	}

	public void setVerifExpr(VerificaExpressao verifExpr) {
		this.verifExpr = verifExpr;
	}

}
