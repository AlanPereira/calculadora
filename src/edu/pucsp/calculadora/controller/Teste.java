package edu.pucsp.calculadora.controller;

import java.util.StringTokenizer;

public class Teste {

	public static void main(String[] args) {
		String str = "3553+77-(877-44)-888";
		String delim = "+-()";
	
		
		System.out.println("---- Split by comma ',' ------");
		StringTokenizer st2 = new StringTokenizer(str, delim);

		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
			System.out.println(st2);
		}
	}

}

