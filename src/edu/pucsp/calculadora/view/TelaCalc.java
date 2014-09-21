package edu.pucsp.calculadora.view;

import java.util.Scanner;

import javax.swing.JFrame;
import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;

public class TelaCalc extends JFrame implements ITela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9092516440173107952L;
	
	private IControle c;
	
	public TelaCalc(IControle c){
		this.c = c;
	}

	public void iniciar(){		
		Scanner scan = new Scanner(System.in);
		while(true){
		
		System.out.println("Digite a expressao:");
		System.out.println(c.calcular(scan.nextLine()));
		}
	}
	


	
}
