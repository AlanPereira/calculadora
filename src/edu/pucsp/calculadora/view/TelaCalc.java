package edu.pucsp.calculadora.view;

import javax.swing.JFrame;

import edu.pucsp.calculadora.controller.Controler;
import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;

public class TelaCalc extends JFrame implements ITela{
	
	private IControle c;
	
	public TelaCalc(IControle c){
		this.c = c;
	}

	public void iniciar(){
		
	}
	


	
}
