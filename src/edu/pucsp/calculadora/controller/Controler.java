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
		
	public void gravar(String expr, String result){
		
	}

	@Override
	public String calcular(String expressao) {
		return calcularEquacao(expressao);
	}
	
	private String calcularEquacao(String expressao){
		String result= "Erro de sintaxe";
		
		if(getVerifExpr().validaExpressao(expressao)){
			result = (new Calculadora().CalcularExp((new PreparaEquacao()).converteInfixa(getVerifExpr().getList())));
		}
		gravar(expressao, result);
		return result;
	}

	private VerificaExpressao getVerifExpr() {
		return verifExpr;
	}

	private void setVerifExpr(VerificaExpressao verifExpr) {
		this.verifExpr = verifExpr;
	}

}
