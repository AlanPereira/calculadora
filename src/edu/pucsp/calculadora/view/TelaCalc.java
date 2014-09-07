package edu.pucsp.calculadora.view;

import javax.swing.JFrame;

import edu.pucsp.calculadora.controller.Controler;

public class TelaCalc extends JFrame{
	private Controler c;
	
	public Controler getC() {
		return c;
	}

	public void setC(Controler c) {
		this.c = c;
	}

	public TelaCalc(Controler c)
	{
		setC(c);
	}
}
