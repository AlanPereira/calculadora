package edu.pucsp.calculadora.controller;
import edu.pucsp.calculadora.cliente.Cliente;
import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;
import edu.pucsp.calculadora.view.Visual;



public class Controler implements IControle{
	private ITela tela;
	
	//private LogFileText logTxt;
	
	private ITela getITela() {
		return tela;
	}

	private void setITela(ITela tela) {
		this.tela = tela;
	}
	
	public Controler()
	{
		setITela(new Visual(this));//talves trocar para o iniciar;
		
	}
	
	public void iniciar(){
		getITela().iniciar();
	}
		

	@Override
	public String calcular(String expressao) {
		return (new Cliente()).calcular(expressao);
	}

}
