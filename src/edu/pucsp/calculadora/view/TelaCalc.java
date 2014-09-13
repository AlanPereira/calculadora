package edu.pucsp.calculadora.view;

import java.util.Scanner;

import javax.swing.JFrame;
import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;

public class TelaCalc extends JFrame implements ITela{
	
	private IControle c;
	
	public TelaCalc(IControle c){
		this.c = c;
	}

	public void iniciar(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite a express�o:");
		System.out.println(c.calcular(scan.nextLine()));
		scan.close();
	}
	


	
}
