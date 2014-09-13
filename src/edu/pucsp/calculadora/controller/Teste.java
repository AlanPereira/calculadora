package edu.pucsp.calculadora.controller;

public class Teste {

	public static void main(String[] args) {
		String str = "3*(10+67-2-()+3";
		VerificaExpressao  v = new VerificaExpressao();
		if(v.validaExpressao(str)){
			System.out.println("\n\n"+str);
		}else
			System.out.println("Falhou");

	}

}

